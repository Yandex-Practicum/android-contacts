package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback<T extends ListDiffInterface> extends DiffUtil.ItemCallback<T> {

    public boolean theSameAs(T object) {
        return false;
    }

    public boolean equals(Object object) {
        return false;
    }


    @Override
    public boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.theSameAs(theSameAs(newItem));
    }

    @Override
    public boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.equals(newItem);
    }
}
