package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {

    // Метод для сравнения элементов (аналог areItemsTheSame)
    boolean theSameAs(T other);

    // Объявляем equals как обязательный для реализации
    @Override
    boolean equals(Object other);
}