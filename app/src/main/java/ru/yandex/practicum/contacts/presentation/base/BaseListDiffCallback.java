package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback<T extends ListDiffInterface<T>> extends DiffUtil.ItemCallback<T> {

    @Override
    public boolean areItemsTheSame(@NonNull T t, @NonNull T newItem) {
        return t.theSameAs(newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull T t, @NonNull T newItem) {
        return t.equals(newItem);
    }
}
