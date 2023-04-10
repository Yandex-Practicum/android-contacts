package ru.yandex.practicum.contacts.presentation.base;

import java.util.Objects;

public interface ListDiffInterface<T> {
    boolean theSameAs(ListDiffInterface<T> t);

    boolean equals(Object o);
}
