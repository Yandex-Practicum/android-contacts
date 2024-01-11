package ru.yandex.practicum.contacts.presentation.base;

public  interface ListDiffInterface <T>{
    boolean theSameAs(T item);
    boolean equals(Object obj);
}
