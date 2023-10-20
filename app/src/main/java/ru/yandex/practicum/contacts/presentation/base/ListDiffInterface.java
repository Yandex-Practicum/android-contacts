package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface <T>{
    boolean theSameAs(T compareObject);

    boolean equals(Object obj);

}
