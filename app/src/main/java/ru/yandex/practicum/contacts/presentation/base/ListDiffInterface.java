package ru.yandex.practicum.contacts.presentation.base;


public interface ListDiffInterface<T> {

    default boolean theSameAs(T sameObject) {
        return this == sameObject;
    }

    boolean equals(Object o);
}
