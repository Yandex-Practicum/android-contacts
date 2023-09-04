package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback <AnotherItem extends ListDiffInterface<AnotherItem>> extends DiffUtil.ItemCallback<AnotherItem> {



    public Object getChangePayload(AnotherItem t) {
        return t;
    }

    @Override
    public boolean areItemsTheSame(@NonNull AnotherItem oldItem, @NonNull AnotherItem newItem) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull AnotherItem oldItem, @NonNull AnotherItem newItem) {
        return false;
    }
}


