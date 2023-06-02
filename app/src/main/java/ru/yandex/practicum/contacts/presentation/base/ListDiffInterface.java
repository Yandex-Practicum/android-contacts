package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface <T>{
    Boolean theSameAs(T Item);

    @Override
    boolean equals(Object object);

}
