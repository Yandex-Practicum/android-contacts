package ru.yandex.practicum.contacts.presentation.main;

import androidx.annotation.NonNull;

import java.util.List;

import ru.yandex.practicum.contacts.model.ContactType;
import ru.yandex.practicum.contacts.presentation.base.ListDiffInterface;

// public class ContactUi
public class ContactUi implements ListDiffInterface<ContactUi> // Шаг 2. Реализация интерфейса
{

    private final String name;
    private final String phone;
    private final String photo;
    private final List<ContactType> types;

    public ContactUi
    (
            @NonNull String name,
            @NonNull String phone,
            @NonNull String photo,
            @NonNull List<ContactType> types
    )
        {
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
/// Шаг 2. Реализация интерфейса  ContactUI и theSameAs()
    @Override
    public boolean theSameAs (ContactUi t_same) {return this.hashCode() == t_same.hashCode();}
  // boolean theSameAs (T_item t_Same);
//  public boolean theSameAs (ContactUi t) {return this.hashCode() == t.hashCode();}
///
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactUi contact = (ContactUi) o;

        if (!name.equals(contact.name)) return false;
        if (!phone.equals(contact.phone)) return false;
        if (!photo.equals(contact.photo)) return false;
        return types.equals(contact.types);
    }

    @Override
    public int hashCode()
    {
        int result = name.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + photo.hashCode();
        result = 31 * result + types.hashCode();
        return result;
    }
} // public class ContactUi
