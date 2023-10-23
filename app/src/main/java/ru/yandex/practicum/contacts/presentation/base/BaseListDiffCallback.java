package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import ru.yandex.practicum.contacts.presentation.main.ContactUi;

public class BaseListDiffCallback <T extends ListDiffInterface<T>> extends DiffUtil.ItemCallback<T> { //3 - шаг Создать дженерик класс который имеет ограничение на использование наследников интерфейса ListDiffInterface

    //3 шаг - Переопределить необходимые для реализации методы, реализовать метод areItemsTheSame с использованием theSameAs из интерфейса ListDiffInterface
    @Override
    public boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.theSameAs(newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.equals(newItem);
    }

    //2 правка - getChangePayload добавлен
    @Nullable
    @Override
    public Object getChangePayload(@NonNull T oldItem, @NonNull T newItem) {
        return newItem;
    }



}
