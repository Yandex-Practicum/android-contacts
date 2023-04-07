package ru.yandex.practicum.contacts.presentation.base;

import ru.yandex.practicum.contacts.presentation.filter.model.FilterContactTypeUi;
import ru.yandex.practicum.contacts.presentation.main.ContactUi;
import ru.yandex.practicum.contacts.presentation.sort.SortTypeUI;

public interface ListDiffInterface<T> {

    default boolean theSameAs(T t) {
        //return boolean;
        return (boolean) t;
    }


    // из ContactUi
    public boolean equals(Object o) {
        if (o instanceof ContactUi) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ContactUi contact = (ContactUi) o;

            if (!name.equals(contact.name)) return false;
            if (!phone.equals(contact.phone)) return false;
            if (!photo.equals(contact.photo)) return false;
            return types.equals(contact.types);
        } else if (o instanceof FilterContactTypeUi) {
            //из FilterContactTypeUi

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            FilterContactTypeUi that = (FilterContactTypeUi) o;

            if (selected != that.selected) return false;
            return contactType == that.contactType;
        } else if (o instanceof SortTypeUI) {
            //из SortTypeUI
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SortTypeUI that = (SortTypeUI) o;

            if (selected != that.selected) return false;
            return sortType == that.sortType;
            }
        }
    }
