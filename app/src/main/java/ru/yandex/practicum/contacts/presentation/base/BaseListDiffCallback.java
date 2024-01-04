package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback <D extends ListDiffInterface<D>> extends DiffUtil.ItemCallback<D>  {
    D d;
    @Override
    public boolean areItemsTheSame(@NonNull D oldItem, @NonNull D newItem){
        return oldItem.theSameAs(newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull D oldItem, @NonNull D newItem) {
        return oldItem.equals(newItem);
    }
}
