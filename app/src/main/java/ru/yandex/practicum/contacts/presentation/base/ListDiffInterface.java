package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import ru.yandex.practicum.contacts.presentation.main.ContactUi;

public interface ListDiffInterface<T>{

    boolean theSameAs(@NonNull T oldItem);

    boolean equals(Object o);
}
