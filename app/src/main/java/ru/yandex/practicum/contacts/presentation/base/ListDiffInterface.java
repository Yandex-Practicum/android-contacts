package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {

    boolean theSameAs(T value);
    boolean equals(Object o);

}
