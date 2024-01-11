package ru.yandex.practicum.contacts.presentation.base;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback <T extends ListDiffInterface> extends DiffUtil.ItemCallback<T> {
    @Override
    public boolean areContentsTheSame(@NonNull T newItem,@NonNull T oldItem) {
        return oldItem.equals(newItem);
    }
    @Nullable
    @Override
    public T getChangePayload(@NonNull T oldItem, @NonNull T newItem){
        return newItem;
    }
    @Override
    public boolean areItemsTheSame(@NonNull T newItem,@NonNull T oldItem) {
        return oldItem.theSameAs(newItem);
    }
}
