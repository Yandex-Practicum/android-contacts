package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {

    public default  boolean theSameAs() {
        return false;
    }

    public static Object equals() {

        return false;
    }

}
