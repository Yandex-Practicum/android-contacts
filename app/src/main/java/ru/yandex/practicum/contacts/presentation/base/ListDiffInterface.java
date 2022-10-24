package ru.yandex.practicum.contacts.presentation.base;
//some comment
public interface ListDiffInterface<T> {
    boolean theSameAs(T newItem);

    boolean equals(Object o);
}
