package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<D> {
    boolean theSameAs(D d);

    boolean equals(Object o);
}
