package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface <T>{
    Boolean theSameAs(T Item);

    boolean equals(Object object);

}
