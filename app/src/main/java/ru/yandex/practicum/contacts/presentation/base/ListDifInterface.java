package ru.yandex.practicum.contacts.presentation.base;

public interface ListDifInterface<T> {
    boolean theSameAs(T a);
    boolean equals(Object a);
}
