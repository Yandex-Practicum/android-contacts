package ru.yandex.practicum.contacts.presentation.base;

import java.util.Objects;

public interface ListDiffInterface<T> {
    boolean theSameAs(T t);

    boolean equals(Object o);
}
