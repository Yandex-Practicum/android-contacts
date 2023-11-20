package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {
    boolean theSameAs(T newType);

    boolean equals(Object object);
}
