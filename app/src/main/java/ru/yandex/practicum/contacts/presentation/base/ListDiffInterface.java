package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {

        boolean theSameAs(T x);
        boolean equals(Object x);
}
