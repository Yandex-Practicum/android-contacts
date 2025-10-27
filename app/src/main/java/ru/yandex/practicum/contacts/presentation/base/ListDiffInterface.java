package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {

    boolean theSameAs(T elementOther1);

    @Override
    boolean equals(Object elementOther1);
}