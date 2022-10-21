package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback<TypeUi extends ListDiffInterface<TypeUi>> extends DiffUtil.ItemCallback<TypeUi> {

   @Override
    public boolean areItemsTheSame(@NonNull TypeUi oldItem, @NonNull TypeUi newItem) {
       return oldItem.theSameAs(newItem);

   }

    @Override
    public boolean areContentsTheSame(@NonNull TypeUi oldItem, @NonNull TypeUi newItem) {
        return oldItem.equals(newItem);
    }

    @Nullable
    @Override
    public Object getChangePayload(@NonNull TypeUi oldItem, @NonNull TypeUi newItem) {
        return newItem;
    }

}
