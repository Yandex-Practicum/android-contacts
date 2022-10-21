package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface <TypeUi> {

    boolean theSameAs(TypeUi newItem);

    boolean equals(Object object);
}
