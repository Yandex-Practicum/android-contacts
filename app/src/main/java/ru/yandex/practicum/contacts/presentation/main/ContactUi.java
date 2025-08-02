package ru.yandex.practicum.contacts.presentation.main;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Objects;

import ru.yandex.practicum.contacts.model.ContactType;
import ru.yandex.practicum.contacts.presentation.base.ListDiffInterface;

public class ContactUi implements ListDiffInterface<ContactUi> {

    private final String name;
    private final String phone;
    private final String photo;
    private final List<ContactType> types;

    public ContactUi(@NonNull String name, @NonNull String phone, @NonNull String photo, @NonNull List<ContactType> types) {
        this.name = name;
        this.phone = phone;
        this.photo = photo;
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPhoto() {
        return photo;
    }

    public List<ContactType> getTypes() {
        return types;
    }

    @Override
    public boolean theSameAs(ContactUi other) {
        // Можно использовать любой способ сравнения, вот — через hashCode, как в оригинале:
        return this.hashCode() == other.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactUi)) return false;
        ContactUi contact = (ContactUi) o;
        return name.equals(contact.name) &&
                phone.equals(contact.phone) &&
                photo.equals(contact.photo) &&
                types.equals(contact.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, photo, types);
    }
}
