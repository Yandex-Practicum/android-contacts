package ru.yandex.practicum.contacts.model;

import androidx.annotation.NonNull;

import java.util.List;

public class Contact {

    private final int id;
    private final String prefix;
    private final String firstName;
    private final String middleName;
    private final String surname;
    private final String suffix;
    private final String photoUri;
    private final List<PhoneNumber> phoneNumbers;
    private final List<Email> emails;
    private final List<Address> addresses;
    private final String source;
    private final int starred;
    private final int contactId;
    private final String thumbnailUri;

    public Contact(int id, @NonNull String prefix, @NonNull String firstName, @NonNull String middleName, @NonNull String surname,
                   @NonNull String suffix, @NonNull String photoUri, @NonNull List<PhoneNumber> phoneNumbers, @NonNull List<Email> emails,
                   @NonNull List<Address> addresses, @NonNull String source, int starred, int contactId, @NonNull String thumbnailUri
    ) {
        this.id = id;
        this.prefix = prefix;
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.suffix = suffix;
        this.photoUri = photoUri;
        this.phoneNumbers = phoneNumbers;
        this.emails = emails;
        this.addresses = addresses;
        this.source = source;
        this.starred = starred;
        this.contactId = contactId;
        this.thumbnailUri = thumbnailUri;
    }

    public int getId() {
        return id;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurname() {
        return surname;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getPhotoUri() {
        return photoUri;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public String getSource() {
        return source;
    }

    public int getStarred() {
        return starred;
    }

    public int getContactId() {
        return contactId;
    }

    public String getThumbnailUri() {
        return thumbnailUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (id != contact.id) return false;
        if (starred != contact.starred) return false;
        if (contactId != contact.contactId) return false;
        if (!prefix.equals(contact.prefix)) return false;
        if (!firstName.equals(contact.firstName)) return false;
        if (!middleName.equals(contact.middleName)) return false;
        if (!surname.equals(contact.surname)) return false;
        if (!suffix.equals(contact.suffix)) return false;
        if (!photoUri.equals(contact.photoUri)) return false;
        if (!phoneNumbers.equals(contact.phoneNumbers)) return false;
        if (!emails.equals(contact.emails)) return false;
        if (!addresses.equals(contact.addresses)) return false;
        if (!source.equals(contact.source)) return false;
        return thumbnailUri.equals(contact.thumbnailUri);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + prefix.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + suffix.hashCode();
        result = 31 * result + photoUri.hashCode();
        result = 31 * result + phoneNumbers.hashCode();
        result = 31 * result + emails.hashCode();
        result = 31 * result + addresses.hashCode();
        result = 31 * result + source.hashCode();
        result = 31 * result + starred;
        result = 31 * result + contactId;
        result = 31 * result + thumbnailUri.hashCode();
        return result;
    }
}
