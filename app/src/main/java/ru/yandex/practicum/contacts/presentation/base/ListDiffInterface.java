package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface <T>{
    boolean theSameAs(T typeGen);
    boolean equals(Object obj);
}
