package ru.yandex.practicum.contacts.presentation.base;

import androidx.recyclerview.widget.DiffUtil;

import ru.yandex.practicum.contacts.presentation.filter.model.FilterContactTypeUi;
import ru.yandex.practicum.contacts.presentation.main.ContactUi;

public interface ListDiffInterface<T> {
    boolean theSameAs(T object);
    boolean equals(Object object);
}
