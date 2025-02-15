package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface <T>  {
    public boolean theSameAs(T comparableObj);
    @Override
    public boolean equals(Object comparableObj);

}
