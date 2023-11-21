package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {
    <D>boolean theSameAs(D object);

    boolean equals(Object object);
}
