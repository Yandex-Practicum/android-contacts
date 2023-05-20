package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {
        boolean equals(Object object);

        boolean theSameAs(T tobject);
    }

