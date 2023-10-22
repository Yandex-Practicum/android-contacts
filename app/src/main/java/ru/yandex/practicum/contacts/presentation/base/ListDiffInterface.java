package ru.yandex.practicum.contacts.presentation.base;

import ru.yandex.practicum.contacts.presentation.filter.model.FilterContactTypeUi;
import ru.yandex.practicum.contacts.presentation.main.ContactUi;

public interface ListDiffInterface<T> {//1 шаг создать интерфейс
    //1 шаг. создать Bollean метод theSameAs(), который принимает на вход дженерик тип
     <T> boolean theSameAs(T t) ;


    //1 шаг. Создать метод equals c возможностью его переопределения
    boolean equals(Object obj);

}
