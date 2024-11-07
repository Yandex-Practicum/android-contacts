package ru.yandex.practicum.contacts.presentation.main;

import androidx.annotation.NonNull;

import java.util.List;

import ru.yandex.practicum.contacts.model.ContactType;
import ru.yandex.practicum.contacts.presentation.base.ListDiffInterface;

public class ContactUi implements ListDiffInterface<ContactUi>  {

    private final String name;
    private final String phone;
    private final String photo;
    private final List<ContactType> types;

    public ContactUi(
            @NonNull String name,
            @NonNull String phone,
            @NonNull String photo,
            @NonNull List<ContactType> types
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
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + photo.hashCode();
        result = 31 * result + types.hashCode();
        return result;
    }


    @Override
    public boolean theSameAs(ContactUi contactUi) {
        return this.hashCode() == contactUi.hashCode();
    }
}
