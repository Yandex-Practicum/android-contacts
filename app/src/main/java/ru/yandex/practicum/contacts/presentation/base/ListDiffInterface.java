package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface <AnotherItem>{
     boolean  theSameAs(AnotherItem anotherItem);
    boolean equals(Object o);
}
