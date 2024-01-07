package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback<R extends ListDiffInterface<R>> extends DiffUtil.ItemCallback<R> {

    @Override
    public boolean areItemsTheSame(@NonNull R oldItem, @NonNull R newItem) {
        return oldItem.theSameAs(newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull R oldItem, @NonNull R newItem) {
        return oldItem.equals(newItem);
    }

    @Nullable
    @Override
    public Object getChangePayload(@NonNull R oldItem, @NonNull R newItem) {
        return newItem;
    }
}
