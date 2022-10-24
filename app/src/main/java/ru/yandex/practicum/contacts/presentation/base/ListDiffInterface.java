package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;

import ru.yandex.practicum.contacts.presentation.main.ContactUi;

public interface ListDiffInterface<T> { //<T extends equals>

    public boolean theSameAs(T item);


    // сделать обязательным к реализации
    boolean equals(Object obj);

}
