package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback<T extends ListDiffInterface> extends DiffUtil.ItemCallback<T> {

    @Override
    public boolean areItemsTheSame(@NonNull ListDiffInterface oldItem, @NonNull ListDiffInterface newItem) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull ListDiffInterface oldItem, @NonNull ListDiffInterface newItem) {
        return false;
    }
}
