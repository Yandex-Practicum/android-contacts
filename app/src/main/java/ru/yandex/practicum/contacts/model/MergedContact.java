package ru.yandex.practicum.contacts.model;

import androidx.annotation.NonNull;

import java.util.List;

public class MergedContact {

    private final int id;
    private final String firstName;
    private final String middleName;
    private final String surname;
    private final String phone;
    private final String normalizedNumber;
    private final String email;
    private final List<String> contactTypes;
    private final String photoUri;

    public MergedContact(int id, @NonNull String firstName, @NonNull String middleName, @NonNull String surname, @NonNull String phone,
                         @NonNull String normalizedNumber, @NonNull String email, @NonNull List<String> contactTypes, @NonNull String photoUri
    ) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.phone = phone;
        this.normalizedNumber = normalizedNumber;
        this.email = email;
        this.contactTypes = contactTypes;
        this.photoUri = photoUri;
    }

    public int getId() {
        return id;
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

    public String getPhone() {
        return phone;
    }

    public String getNormalizedNumber() {
        return normalizedNumber;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getContactTypes() {
        return contactTypes;
    }

    public String getPhotoUri() {
        return photoUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MergedContact that = (MergedContact) o;

        if (id != that.id) return false;
        if (!firstName.equals(that.firstName)) return false;
        if (!middleName.equals(that.middleName)) return false;
        if (!surname.equals(that.surname)) return false;
        if (!phone.equals(that.phone)) return false;
        if (!normalizedNumber.equals(that.normalizedNumber)) return false;
        if (!email.equals(that.email)) return false;
        if (!contactTypes.equals(that.contactTypes)) return false;
        return photoUri.equals(that.photoUri);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + normalizedNumber.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + contactTypes.hashCode();
        result = 31 * result + photoUri.hashCode();
        return result;
    }
}
