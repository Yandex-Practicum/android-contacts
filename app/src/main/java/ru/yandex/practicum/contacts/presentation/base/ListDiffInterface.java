package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface <T> {
    boolean theSameAs(T thing);
    boolean equals(Object obj);
}
