package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {
   boolean theSameAs(ListDiffInterface<T> listDiffInterface);

   boolean equals(Object o);
}
