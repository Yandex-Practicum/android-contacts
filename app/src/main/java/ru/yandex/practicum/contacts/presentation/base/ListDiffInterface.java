package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {
    boolean theSaneAs(T t);

    boolean equals(Object o);
}
