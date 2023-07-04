package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import ru.yandex.practicum.contacts.presentation.main.ContactUi;

public class BaseListDiffCallback<A extends ListDiffInterface<A>> extends DiffUtil.ItemCallback<A> {

    public boolean areItemsTheSame(@NonNull A oldItem, @NonNull A newItem) {
        return oldItem.hashCode() == newItem.hashCode();
    }


    public boolean areContentsTheSame(@NonNull A oldItem, @NonNull A newItem) {
        return oldItem.equals(newItem);
    }

    @Nullable

    public Object getChangePayload(@NonNull A oldItem, @NonNull A newItem) {
        return newItem;
    }
}
