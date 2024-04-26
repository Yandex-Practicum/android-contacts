package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffCallback<T> {

    boolean theSameAs(T t);

    boolean equals(Object o);
}
