package ru.yandex.practicum.contacts.presentation.base;

import ru.yandex.practicum.contacts.model.Contact;
import ru.yandex.practicum.contacts.presentation.filter.model.FilterContactTypeUi;
import ru.yandex.practicum.contacts.presentation.main.ContactUi;
import ru.yandex.practicum.contacts.presentation.sort.SortTypeUI;

public interface ListDiffInterface<T> {

    default boolean theSameAs(T t) {
        //return boolean;
        return (boolean) t;
    }


    // из ContactUi
    default boolean equals(Object o) {
        Object that;
        that = null;

        if (o instanceof ContactUi) {
            that = (Contact) o;
        } else if (o instanceof FilterContactTypeUi) {
            //из FilterContactTypeUi
            that = (FilterContactTypeUi) o;
        } else if (o instanceof SortTypeUI) {
            //из SortTypeUI
            that = (SortTypeUI) o;
        }
        if (this == that) {
            return true;
            if (o == null || getClass() != o.getClass()) return false;
        }
    }
}
