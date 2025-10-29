package ru.yandex.practicum.contacts.presentation.main;

import java.util.Objects;
import ru.yandex.practicum.contacts.presentation.base.ListDiffInterface;

import java.util.List;

import ru.yandex.practicum.contacts.model.ContactType;

public class ContactUi implements ListDiffInterface<ContactUi> {

    private final String name;
    private final String phone;
    private final String photo;
    private final List<ContactType> types;

    public ContactUi(
           String name,
            String phone,
             String photo,
            List<ContactType> types
    ) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactUi contact = (ContactUi) o;

        if (!name.equals(contact.name)) return false;
        if (!phone.equals(contact.phone)) return false;
        if (!photo.equals(contact.photo)) return false;
        return types.equals(contact.types);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, phone, photo, types);
    }
    public boolean theSameAs(ContactUi other) {
        return this.hashCode() == other.hashCode();
    }
}
