package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;


public class BaseListDiffCallback <T> extends DiffUtil.ItemCallback<T> implements ListDiffInterface<T>{
    @Override
    public boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return false;
    }

    @Override
    public boolean theSameAs(T baseListDiffCallback) {
        return false;
    }
}
