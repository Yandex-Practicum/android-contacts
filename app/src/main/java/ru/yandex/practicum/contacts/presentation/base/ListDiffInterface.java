package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {
 boolean theSameAs(T otherObject);
 boolean  equals(Object o);
}