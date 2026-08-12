package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffCallback<T> {

    boolean theSameAs(T item);
    boolean equals(Object obj);
}