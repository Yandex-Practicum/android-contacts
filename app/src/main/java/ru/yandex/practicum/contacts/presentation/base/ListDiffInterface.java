package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {
//    Первый метод, назовём его theSameAs(), должен возвращать значение типа boolean. А на вход этот метод должен принимать один объект того же типа, что и класс, который будет реализовывать этот интерфейс.
//    Интерфейс должен быть дженериком с одним параметром типа, и этот обобщённый тип будет служить типом данных объекта, передаваемого в метод theSameAs().
    boolean theSameAs(T other);
    boolean equals(Object o);
}
