package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {
    boolean theSameAs(T obj);

    @Override
    boolean equals(Object obj);
}
