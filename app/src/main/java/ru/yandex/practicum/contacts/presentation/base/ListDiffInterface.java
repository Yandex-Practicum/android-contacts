package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {

    boolean theSameAs(T objectToCompare);
    boolean equals(Object object);

}
