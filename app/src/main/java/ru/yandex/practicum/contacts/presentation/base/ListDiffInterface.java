package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {//создан по заданию 2
    public boolean theSameAs(T param);
    public boolean equals(Object o);
}
