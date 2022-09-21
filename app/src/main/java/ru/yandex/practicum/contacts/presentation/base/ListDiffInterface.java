package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {

    // Первый метод, назовём его theSameAs(), должен возвращать значение типа boolean.
    // А на вход этот метод должен принимать один объект того же типа,
    // что и класс, который будет реализовывать этот интерфейс.
    public boolean theSameAs(T obj);

    //Нам нужно, чтобы данные в объекте сравнивались и возвращали true, если данные совпадают и false, если нет.
    //Нужно сделать этот метод обязательным к реализации с возможностью переопределения этого метода.
    public boolean equals(Object o);


}
