package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {
    boolean theSameAs(T item);

    @Override
    boolean equals(Object obj);
}
