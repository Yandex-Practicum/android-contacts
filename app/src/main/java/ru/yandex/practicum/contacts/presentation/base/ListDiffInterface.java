package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {
    boolean theSameAs(T elementTemp1);

    @Override
    boolean equals(Object elementTemp1);
}
