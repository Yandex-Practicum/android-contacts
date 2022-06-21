package ru.yandex.practicum.contacts.repository;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Groups;
import android.provider.ContactsContract.RawContacts;
import android.provider.ContactsContract.Settings;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import ru.yandex.practicum.contacts.model.ContactSource;
import ru.yandex.practicum.contacts.utils.Constants;
import ru.yandex.practicum.contacts.utils.android.ContextUtils;
import ru.yandex.practicum.contacts.utils.android.CursorUtils;

public class ContactSourceRepository {

    private final Context context;

    private boolean wasLocalAccountInitialized = false;

    public ContactSourceRepository(Context context) {
        this.context = context;
    }

    public Set<ContactSource> getAllContactSources() {
        if (!ContextUtils.hasContactPermissions(context)) {
            return Collections.emptySet();
        }
        if (!wasLocalAccountInitialized) {
            initializeLocalPhoneAccount();
            wasLocalAccountInitialized = true;
        }

        final Set<ContactSource> contactSources = new HashSet<>();
        final Account[] accounts = AccountManager.get(context).getAccounts();
        final Set<ContactSource> accountSources = Arrays.stream(accounts)
                .map(this::getContactSource)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        final Set<ContactSource> contentResolverSources = new HashSet<>(getContentResolverAccounts());

        contactSources.addAll(accountSources);
        contactSources.addAll(contentResolverSources);

        if (!containsRegularPhoneSource(contactSources)) {
            contactSources.add(new ContactSource(Constants.StorageType.PHONE_STORAGE, Constants.StorageType.PHONE_STORAGE, Constants.StorageType.PHONE_STORAGE));
        }

        contactSources.add(new ContactSource(Constants.StorageType.SMT_PRIVATE, Constants.StorageType.SMT_PRIVATE, Constants.StorageType.PHONE_STORAGE_PRIVATE));

        return Collections.unmodifiableSet(contactSources);
    }

    @Nullable
    private ContactSource getContactSource(Account account) {
        if (isSyncable(account)) {
            return new ContactSource(account.name, account.type, getAccountPublicName(account.type, account.name));
        } else {
            return null;
        }
    }

    private Set<ContactSource> getContentResolverAccounts() {
        final Uri[] uris = {Groups.CONTENT_URI, Settings.CONTENT_URI, RawContacts.CONTENT_URI};
        final Set<ContactSource> sources = new HashSet<>();
        for (Uri uri : uris) {
            sources.addAll(fillSourcesFromUri(uri));
        }
        return Collections.unmodifiableSet(sources);
    }

    private Set<ContactSource> fillSourcesFromUri(Uri uri) {
        final Set<ContactSource> sources = new HashSet<>();
        final String[] projection = {RawContacts.ACCOUNT_NAME, RawContacts.ACCOUNT_TYPE};
        ContextUtils.query(context, uri, projection, cursor -> {
            final String name = CursorUtils.getString(cursor, RawContacts.ACCOUNT_NAME);
            final String type = CursorUtils.getString(cursor, RawContacts.ACCOUNT_TYPE);
            final ContactSource source = new ContactSource(name, type, getAccountPublicName(type, name));
            sources.add(source);
        });
        return Collections.unmodifiableSet(sources);
    }

    private boolean isSyncable(Account account) {
        return ContentResolver.getIsSyncable(account, ContactsContract.AUTHORITY) == 1;
    }

    private String getAccountPublicName(String type, String name) {
        switch (type) {
            case (Constants.Packages.GOOGLE):
                return Constants.StorageType.GOOGLE;
            case (Constants.Packages.TELEGRAM):
                return Constants.StorageType.TELEGRAM;
            case (Constants.Packages.SIGNAL):
                return Constants.StorageType.SIGNAL;
            case (Constants.Packages.WHATSAPP):
                return Constants.StorageType.WHATSAPP;
            case (Constants.Packages.VIBER):
                return Constants.StorageType.VIBER;
            case (Constants.Packages.THREEMA):
                return Constants.StorageType.THREEMA;
            default:
                return name;
        }
    }

    private void initializeLocalPhoneAccount() {
        try {
            final ContentProviderOperation.Builder builder = ContentProviderOperation.newInsert(RawContacts.CONTENT_URI);
            builder.withValue(RawContacts.ACCOUNT_NAME, null);
            builder.withValue(RawContacts.ACCOUNT_TYPE, null);

            final ArrayList<ContentProviderOperation> operations = new ArrayList<>();
            operations.add(builder.build());

            final ContentProviderResult[] results = context.getContentResolver().applyBatch(ContactsContract.AUTHORITY, operations);
            final Optional<ContentProviderResult> rawContactUri = Arrays.stream(results).findFirst();
            rawContactUri.ifPresent(value -> context.getContentResolver().delete(value.uri, null, null));
        } catch (Exception ignored) {

        }
    }

    private boolean containsRegularPhoneSource(Set<ContactSource> contactSources) {
        return contactSources.stream().anyMatch(account -> {
            final String accountType = account.getType();
            return accountType.startsWith("com.google") || accountType.startsWith("com.android") || accountType.startsWith("com.qualcomm");
        });
    }
}
