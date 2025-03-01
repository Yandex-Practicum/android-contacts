package ru.yandex.practicum.contacts.presentation.base;

//Шаг 1. Интерфейс
public interface ListDiffInterface<T> {
    // theSameAs(),
    // должен возвращать значение типа boolean.
    // на вход должен принимать один объект того же типа, что и класс, который будет реализовывать этот интерфейс.
    // Интерфейс должен быть дженериком с одним параметром типа,
    boolean theSameAs(T t);
    //equals()
    // принимает в качестве параметра на вход один объект типа Object,
    // а возвращает значение типа boolean.
    boolean equals(Object o);
}
