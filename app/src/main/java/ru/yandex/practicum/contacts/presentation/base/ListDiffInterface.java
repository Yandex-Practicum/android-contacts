package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface <E> { // дженерик интрефейс, сравнения списков
    boolean theSameAs(E elements); // сигнатура метода, тип данных того же типа, что и класс который будет реализовать данный интерфейс

    boolean equals(Object o);

}
