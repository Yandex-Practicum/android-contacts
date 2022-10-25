package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T>{
    boolean theSameAs(T next);
    boolean equals(Object smth);
}
