package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {
    boolean theSame(T t);
    boolean equals(Object o);
}
