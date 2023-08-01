package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {

     boolean theSameAs(T adapter);

     boolean equals(Object u);

}
