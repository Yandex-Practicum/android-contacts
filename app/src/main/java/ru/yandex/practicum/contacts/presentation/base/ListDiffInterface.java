package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface <T>{
     boolean  theSameAs(T anotherItem);
    boolean equals(Object o);
}
