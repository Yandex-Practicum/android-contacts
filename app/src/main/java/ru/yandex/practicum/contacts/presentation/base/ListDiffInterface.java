package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;

import ru.yandex.practicum.contacts.presentation.main.ContactUi;

public interface ListDiffInterface <E>{



    Object o = null;
    boolean equals(Object o);

    boolean theSameAs(E uiType);
}
