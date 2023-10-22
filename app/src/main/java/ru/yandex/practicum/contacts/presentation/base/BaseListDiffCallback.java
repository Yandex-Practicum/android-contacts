package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback<T extends ListDiffInterface> extends DiffUtil.ItemCallback<T> { //3 - шаг Создать дженерик класс который имеет ограничение на использование наследников интерфейса ListDiffInterface

    //3 шаг - Переопределить необходимые для реализации методы, реализовать метод areItemsTheSame с использованием theSameAs из интерфейса ListDiffInterface
    @Override
    public boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.theSameAs(newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return false;
    }



}
