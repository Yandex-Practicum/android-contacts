package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface <T> {
    public boolean theSameAs(T obj);
    public boolean equals(Object object);
}

