package ru.yandex.practicum.contacts.presentation.base;


import java.util.Objects;

public interface ListDiffInterface <T>{
    public boolean theSameAs (T t);
    public boolean equals(Object obj);
}
