package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {

    boolean theSameAs(T type);

    @Override
    boolean equals(Object o);
}
