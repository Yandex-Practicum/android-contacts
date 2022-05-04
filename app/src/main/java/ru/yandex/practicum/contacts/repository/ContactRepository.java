package ru.yandex.practicum.contacts.repository;

import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds;
import android.provider.ContactsContract.CommonDataKinds.Organization;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.CommonDataKinds.StructuredPostal;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import ru.yandex.practicum.contacts.model.Address;
import ru.yandex.practicum.contacts.model.Contact;
import ru.yandex.practicum.contacts.model.Email;
import ru.yandex.practicum.contacts.model.PhoneNumber;
import ru.yandex.practicum.contacts.utils.android.ContextUtils;
import ru.yandex.practicum.contacts.utils.android.CursorUtils;

public class ContactRepository {

    private final Context context;

    public ContactRepository(Context context) {
        this.context = context;
    }

    public List<Contact> getContacts(Collection<String> sources) {
        if (!ContextUtils.hasContactPermissions(context)) {
            return Collections.emptyList();
        }

        List<Contact> contacts = new ArrayList<>();

        final Uri uri = Data.CONTENT_URI;
        final String[] projection = getContactProjection();
        SparseArray<List<Email>> emails = getEmails(sources);
        SparseArray<List<PhoneNumber>> phoneNumbers = getPhoneNumbers(sources);
        SparseArray<List<Address>> addresses = getAddresses(sources);

        String[] mimeTypes = new String[]{Organization.CONTENT_ITEM_TYPE, StructuredName.CONTENT_ITEM_TYPE};
        for (String mimeType : mimeTypes) {
            String selection = Data.MIMETYPE + " = ?";
            String[] selectionArgs = new String[]{mimeType};
            String sortOrder = Data.RAW_CONTACT_ID;

            ContextUtils.query(context, uri, projection, selection, selectionArgs, cursor -> {
                String accountName = CursorUtils.getString(cursor, RawContacts.ACCOUNT_NAME);

                int id = CursorUtils.getInteger(cursor, Data.RAW_CONTACT_ID);
                String prefix = "";
                String firstName = "";
                String middleName = "";
                String surname = "";
                String suffix = "";

                // ignore names at Organization type contacts
                if (Objects.equals(mimeType, StructuredName.CONTENT_ITEM_TYPE)) {
                    prefix = CursorUtils.getString(cursor, StructuredName.PREFIX);
                    firstName = CursorUtils.getString(cursor, StructuredName.GIVEN_NAME);
                    middleName = CursorUtils.getString(cursor, StructuredName.MIDDLE_NAME);
                    surname = CursorUtils.getString(cursor, StructuredName.FAMILY_NAME);
                    suffix = CursorUtils.getString(cursor, StructuredName.SUFFIX);
                }

                String photoUri = CursorUtils.getString(cursor, StructuredName.PHOTO_URI);
                int starred = CursorUtils.getInteger(cursor, StructuredName.STARRED);
                int contactId = CursorUtils.getInteger(cursor, Data.CONTACT_ID);
                String thumbnailUri = CursorUtils.getString(cursor, StructuredName.PHOTO_THUMBNAIL_URI);

                Contact contact = new Contact(
                        id,
                        prefix,
                        firstName,
                        middleName,
                        surname,
                        suffix,
                        photoUri,
                        phoneNumbers.get(id, new ArrayList<>()),
                        emails.get(id, new ArrayList<>()),
                        addresses.get(id, new ArrayList<>()),
                        accountName,
                        starred,
                        contactId,
                        thumbnailUri
                );

                contacts.add(contact);
            });
        }

        return Collections.unmodifiableList(contacts);
    }

    private String[] getContactProjection() {
        return new String[]{
                Data.MIMETYPE,
                Data.CONTACT_ID,
                Data.RAW_CONTACT_ID,
                StructuredName.PREFIX,
                StructuredName.GIVEN_NAME,
                StructuredName.MIDDLE_NAME,
                StructuredName.FAMILY_NAME,
                StructuredName.SUFFIX,
                StructuredName.PHOTO_URI,
                StructuredName.PHOTO_THUMBNAIL_URI,
                StructuredName.STARRED,
                StructuredName.CUSTOM_RINGTONE,
                RawContacts.ACCOUNT_NAME,
                RawContacts.ACCOUNT_TYPE
        };
    }

    private SparseArray<List<Email>> getEmails(Collection<String> sources) {
        SparseArray<List<Email>> emails = new SparseArray<>();
        Uri uri = CommonDataKinds.Email.CONTENT_URI;
        String[] projection = new String[]{
                Data.RAW_CONTACT_ID,
                CommonDataKinds.Email.DATA,
                CommonDataKinds.Email.TYPE,
                CommonDataKinds.Email.LABEL
        };

        String selection = getSourcesSelection(sources.size());
        String[] selectionArgs = getSourcesSelectionArgs(sources);

        ContextUtils.query(context, uri, projection, selection, selectionArgs, cursor -> {
            int id = CursorUtils.getInteger(cursor, Data.RAW_CONTACT_ID);
            String email = CursorUtils.getString(cursor, CommonDataKinds.Email.DATA);
            int type = CursorUtils.getInteger(cursor, CommonDataKinds.Email.TYPE);
            String label = CursorUtils.getString(cursor, CommonDataKinds.Email.LABEL);

            if (!TextUtils.isEmpty(email)) {
                if (emails.get(id) == null) {
                    emails.put(id, new ArrayList<>());
                }
                emails.get(id).add(new Email(email, type, label));
            }
        });
        return emails;
    }

    private SparseArray<List<PhoneNumber>> getPhoneNumbers(Collection<String> sources) {
        SparseArray<List<PhoneNumber>> phoneNumbers = new SparseArray<>();
        Uri uri = Phone.CONTENT_URI;
        String[] projection = new String[]{
                Data.RAW_CONTACT_ID,
                Phone.NUMBER,
                Phone.NORMALIZED_NUMBER,
                Phone.TYPE,
                Phone.LABEL
        };

        String selection = getSourcesSelection(sources.size());
        String[] selectionArgs = getSourcesSelectionArgs(sources);

        ContextUtils.query(context, uri, projection, selection, selectionArgs, cursor -> {
            int id = CursorUtils.getInteger(cursor, Data.RAW_CONTACT_ID);
            String number = CursorUtils.getString(cursor, Phone.NUMBER);
            String normalizedNumber = CursorUtils.getString(cursor, Phone.NORMALIZED_NUMBER);
            int type = CursorUtils.getInteger(cursor, Phone.TYPE);
            String label = CursorUtils.getString(cursor, Phone.LABEL);

            if (!TextUtils.isEmpty(number)) {
                if (TextUtils.isEmpty(normalizedNumber)) {
                    normalizedNumber = PhoneNumberUtils.normalizeNumber(number);
                }
                if (phoneNumbers.get(id) == null) {
                    phoneNumbers.put(id, new ArrayList<>());
                }
                PhoneNumber phoneNumber = new PhoneNumber(number, type, label, normalizedNumber);
                phoneNumbers.get(id).add(phoneNumber);
            }
        });

        return phoneNumbers;
    }

    private SparseArray<List<Address>> getAddresses(Collection<String> sources) {
        SparseArray<List<Address>> addresses = new SparseArray<>();
        Uri uri = StructuredPostal.CONTENT_URI;
        String[] projection = new String[]{
                Data.RAW_CONTACT_ID,
                StructuredPostal.FORMATTED_ADDRESS,
                StructuredPostal.TYPE,
                StructuredPostal.LABEL
        };

        String selection = getSourcesSelection(sources.size());
        String[] selectionArgs = getSourcesSelectionArgs(sources);

        ContextUtils.query(context, uri, projection, selection, selectionArgs, cursor -> {
            int id = CursorUtils.getInteger(cursor, Data.RAW_CONTACT_ID);
            String address = CursorUtils.getString(cursor, StructuredPostal.FORMATTED_ADDRESS);
            int type = CursorUtils.getInteger(cursor, StructuredPostal.TYPE);
            String label = CursorUtils.getString(cursor, StructuredPostal.LABEL);

            if (!TextUtils.isEmpty(address)) {
                if (addresses.get(id) == null) {
                    addresses.put(id, new ArrayList<>());
                }

                addresses.get(id).add(new Address(address, type, label));
            }
        });

        return addresses;
    }

    private String getSourcesSelection(int count) {
        return RawContacts.ACCOUNT_NAME + " IN (" + getQuestionMarks(count) + ")";
    }

    private String getQuestionMarks(int count) {
        final String[] symbols = new String[count];
        Arrays.fill(symbols, "?");
        return TextUtils.join(",", symbols);
    }

    private String[] getSourcesSelectionArgs(Collection<String> sources) {
        return sources.toArray(new String[0]);
    }
}
