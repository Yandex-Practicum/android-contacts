package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

import ru.yandex.practicum.contacts.presentation.main.ContactUi;

public class BaseListDiffCallback <D extends ListDiffInterface<D>> extends DiffUtil.ItemCallback<D> {


    public boolean areItemsTheSame(@NonNull D oldItem, @NonNull D newItem) {
        return oldItem.theSameAs(newItem);
    }

    public boolean areContentsTheSame(@NonNull D oldItem, @NonNull D newItem) {
        return Objects.equals(oldItem, newItem);
    }

    public boolean theSameAs(BaseListDiffCallback baseListDiffCallback){
        return this.hashCode() == baseListDiffCallback.hashCode();
    }

    public Object getChangePayload(@NonNull D oldItem, @NonNull D newItem) {
        return newItem;
    }
}