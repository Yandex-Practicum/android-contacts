package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {
    boolean theSameAs(T object);

    @Override
    boolean equals(Object other);

}
