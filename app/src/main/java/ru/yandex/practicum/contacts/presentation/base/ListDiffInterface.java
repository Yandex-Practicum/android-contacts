package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {
    boolean theSameAs(ListDiffInterface<T> listDiffInterface);

    @Override
    boolean equals(Object o);
}
