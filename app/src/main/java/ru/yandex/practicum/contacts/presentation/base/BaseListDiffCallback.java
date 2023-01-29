package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import ru.yandex.practicum.contacts.presentation.base.ListDiffInterface;
import ru.yandex.practicum.contacts.presentation.main.ContactUi;

public class BaseListDiffCallback <E extends ListDiffInterface <E>> extends DiffUtil.ItemCallback<E> {


    @Override
    public boolean areItemsTheSame(@NonNull E oldItem, @NonNull E newItem) {
        return newItem.theSameAs(oldItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull E oldItem, @NonNull E newItem) {
        return oldItem.equals(newItem);
    }

    @Nullable
    @Override
    public Object getChangePayload(@NonNull E oldItem, @NonNull E newItem) {
        return newItem;
    }


}
