package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import ru.yandex.practicum.contacts.presentation.main.ContactUi;



public class BaseListDiffCallback<T>
        //DiffUtil.ItemCallback< ListDiffInterface<BaseListDiffCallback<T>> > {
extends DiffUtil.ItemCallback<ListDiffInterface<T>> {



    @Override
    public boolean areItemsTheSame(@NonNull ListDiffInterface oldItem, @NonNull ListDiffInterface newItem) {
        return oldItem.theSameAs(newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull ListDiffInterface oldItem, @NonNull ListDiffInterface newItem) {
        return oldItem.equals(newItem);
    }

}

