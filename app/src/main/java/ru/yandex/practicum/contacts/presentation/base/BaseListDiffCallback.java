package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import ru.yandex.practicum.contacts.presentation.main.ContactUi;

public class BaseListDiffCallback <A extends DiffUtil.ItemCallback<A> & ListDiffInterface<BaseListDiffCallback>> {

    ListDiffInterface listDiffInterface = new ListDiffInterface() {

        public boolean theSameAs(@NonNull BaseListDiffCallback oldItem, @NonNull BaseListDiffCallback newItem) {
            return ListDiffInterface.super.theSameAs();
        }
    };


    public boolean areContentsTheSame(@NonNull BaseListDiffCallback oldItem, @NonNull BaseListDiffCallback newItem) {
        return oldItem.equals(newItem);
    }

    @Nullable

    public Object getChangePayload(@NonNull BaseListDiffCallback oldItem, @NonNull BaseListDiffCallback newItem) {
        return newItem;
    }
}
