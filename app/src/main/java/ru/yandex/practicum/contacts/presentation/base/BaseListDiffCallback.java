package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback<T extends ListDiffInterface> extends DiffUtil.ItemCallback<T> {
    public boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.theSameAs(newItem);
    }

    public boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.equals(newItem);
    }

    public T getChangePayload(@NonNull T oldItem, @NonNull T newItem) {
        return newItem;
    }
}
