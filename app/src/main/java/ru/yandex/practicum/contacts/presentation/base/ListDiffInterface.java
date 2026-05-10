package ru.yandex.practicum.contacts.presentation.base;


public interface ListDiffInterface<T> {
    boolean theSameAs(Object o);
    boolean equals(Object o);
}
