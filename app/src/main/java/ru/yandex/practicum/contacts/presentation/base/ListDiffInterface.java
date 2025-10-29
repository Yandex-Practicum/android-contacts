package ru.yandex.practicum.contacts.presentation.base;


    public interface ListDiffInterface <T extends ListDiffInterface<T>>{
        boolean theSameAs(T other);
        @Override
        boolean equals(Object obj);
    }

