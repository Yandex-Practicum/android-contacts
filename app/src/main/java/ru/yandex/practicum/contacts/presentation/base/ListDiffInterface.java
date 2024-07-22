package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface <T> {
   boolean theSameAs(T Object);
   @Override
   boolean equals(Object Object);


}
