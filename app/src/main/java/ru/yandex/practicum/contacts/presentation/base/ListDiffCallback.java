package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffCallback<T> {
    public boolean theSameAs(T t);
    public boolean equals(Object t);
}
