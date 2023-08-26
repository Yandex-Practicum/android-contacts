package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface {
    <T extends ListDiffInterface> boolean theSameAs(T t);
    boolean equals(Object t);
}
