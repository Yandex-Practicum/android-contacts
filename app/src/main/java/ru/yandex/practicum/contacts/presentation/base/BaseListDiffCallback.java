package ru.yandex.practicum.contacts.presentation.base;

import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback <T extends ListDiffInterface<T>> extends DiffUtil.ItemCallback<T> {

@Override
    public boolean theSameAs(T t) {
        return this.hashCode() == t.hashCode();
    }


    public boolean areContentsTheSame(T t) {
        return this.equals(t);
    }



    public Object getChangePayload(T t) {
        return t;
    }
}


