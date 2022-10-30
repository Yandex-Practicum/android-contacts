package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface <T> {
    boolean theSameAs(final T t);
    @Override
    boolean equals(final Object o);
}
