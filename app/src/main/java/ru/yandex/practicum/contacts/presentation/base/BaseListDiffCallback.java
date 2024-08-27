package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback<t extends ListDiffInterface<t>> extends DiffUtil.ItemCallback<t>{

    @Override
    public boolean areItemsTheSame(@NonNull t oldItem, @NonNull t newItem) {
        return oldItem.theSameAs(newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull t oldItem, @NonNull t newItem) {
        return oldItem.equals(newItem);
    }
}
