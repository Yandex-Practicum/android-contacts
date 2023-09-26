package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class BaseListDiffCallback  <T> extends DiffUtil.ItemCallback<T>{
    @Override
    public boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        if (oldItem instanceof ListDiffInterface && newItem instanceof ListDiffInterface) {
            return ((ListDiffInterface<T>) oldItem).theSameAs(newItem);
        }
        return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return Objects.equals(oldItem, newItem);
    }

    @Nullable
    @Override
    public Object getChangePayload(@NonNull T oldItem, @NonNull T newItem) {
        return newItem;
    }
}
