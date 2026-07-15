package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {

    boolean theSameAs(T otherItem);

    boolean equals(Object otherItem);
}
