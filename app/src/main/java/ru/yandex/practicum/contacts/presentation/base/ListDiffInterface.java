package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {

    boolean theSameAs(T typeOfElementList);

    boolean equals(Object object);
}
