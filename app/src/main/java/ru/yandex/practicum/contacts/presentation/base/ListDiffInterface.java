package ru.yandex.practicum.contacts.presentation.base;

/*
Шаг 1. Интерфейс
Найдите пакет ru.yandex.practicum.contacts.presentation.base и создайте там новый публичный интерфейс
ListDiffInterface.
В этом интерфейсе должно быть объявлено два метода:*/
//обьявление интерфейса

public interface ListDiffInterface <T>{
    boolean theSameAs(T typeGen);
    boolean equals(Object obj);
}
