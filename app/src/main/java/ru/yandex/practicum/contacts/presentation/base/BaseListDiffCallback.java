package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback<BaseListDiffCallback extends ListDiffInterface<BaseListDiffCallback>> extends DiffUtil.ItemCallback<BaseListDiffCallback>{
//    @Override
//    public boolean areItemsTheSame(@NonNull ContactUi oldItem, @NonNull ContactUi newItem) {
//        return oldItem.hashCode() == newItem.hashCode();
//    }
//
//    @Override
//    public boolean areContentsTheSame(@NonNull ContactUi oldItem, @NonNull ContactUi newItem) {
//        return oldItem.equals(newItem);
//    }
//
//    @Nullable
    @Override
    public Object getChangePayload(@NonNull BaseListDiffCallback oldItem, @NonNull BaseListDiffCallback newItem) {
        return newItem;
    }

    @Override
    public boolean areItemsTheSame(@NonNull BaseListDiffCallback oldItem, @NonNull BaseListDiffCallback newItem) {
        return oldItem.theSameAs(newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull BaseListDiffCallback oldItem, @NonNull BaseListDiffCallback newItem) {
        return oldItem.equals(newItem);
    }
}
