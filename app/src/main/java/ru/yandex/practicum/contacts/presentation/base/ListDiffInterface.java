package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<ObjectToTest> {
    boolean theSameAs(ObjectToTest objectToTest);

    boolean equals(Object o);
}
