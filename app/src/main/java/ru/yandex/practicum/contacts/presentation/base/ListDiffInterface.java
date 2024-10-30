package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface <T> {

    boolean theSameAs(T element);
    boolean equals(Object object);
}
