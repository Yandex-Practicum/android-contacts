package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {
    public <T> boolean theSameAs(T t);
    public boolean equals(Object o);
}
