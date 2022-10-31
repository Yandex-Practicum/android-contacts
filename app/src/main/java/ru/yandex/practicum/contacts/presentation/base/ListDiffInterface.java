package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface <T> {

    boolean theSameAs(T t);

    @Override
    boolean equals(Object obj);
}