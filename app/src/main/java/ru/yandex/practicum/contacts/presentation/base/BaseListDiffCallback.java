package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback<BaseListDiffCallback extends ListDiffInterface<BaseListDiffCallback>> extends DiffUtil.ItemCallback<BaseListDiffCallback> {

    @Override
    public boolean areItemsTheSame(BaseListDiffCallback oldItem, BaseListDiffCallback newItem) {
        return oldItem.hashCode() == newItem.hashCode();
    }

    @Override
    public boolean areContentsTheSame(BaseListDiffCallback oldItem,@NonNull BaseListDiffCallback newItem) {
        return oldItem.equals(newItem);
    }

    @Override
    public Object getChangePayload(@NonNull BaseListDiffCallback oldItem,@NonNull BaseListDiffCallback newItem) {
        return newItem;
    }

}
