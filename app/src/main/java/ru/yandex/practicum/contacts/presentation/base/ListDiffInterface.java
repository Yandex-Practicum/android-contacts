package ru.yandex.practicum.contacts.presentation.base;

import androidx.recyclerview.widget.DiffUtil;

public interface ListDiffInterface <T> {

public boolean theSameAs(T t);
public boolean equals(Object t);


    // T t;

}
