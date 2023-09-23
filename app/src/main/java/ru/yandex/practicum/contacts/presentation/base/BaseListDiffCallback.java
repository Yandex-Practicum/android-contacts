package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import ru.yandex.practicum.contacts.presentation.main.ContactUi;

//public class BaseListDiffCallback<T extends DiffUtil.ItemCallback<T> & ListDiffInterface<T>>  {
public class BaseListDiffCallback<T extends ListDiffInterface<T>> extends DiffUtil.ItemCallback<T>  {
        @Override
        public boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {
           // return this.hashCode() == t.hashCode();
             return oldItem.theSameAs(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public Object getChangePayload(@NonNull T oldItem, @NonNull T newItem) {
            return newItem;
    }
}
