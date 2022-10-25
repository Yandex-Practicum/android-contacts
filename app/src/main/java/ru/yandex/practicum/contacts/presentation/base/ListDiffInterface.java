package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {
    public boolean theSameAs(T x);
    public boolean equals(Object y);

}
