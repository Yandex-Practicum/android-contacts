package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {
    boolean theSameAs(T listItem);
    boolean equals(Object obj);
}
