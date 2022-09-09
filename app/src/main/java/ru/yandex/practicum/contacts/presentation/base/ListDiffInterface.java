package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {
    public boolean theSameAs(T item);

    @Override
    public boolean equals(Object object);
}
