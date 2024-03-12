package ru.yandex.practicum.contacts.presentation.base;
import androidx.recyclerview.widget.DiffUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ru.yandex.practicum.contacts.presentation.base.ListDiffCallback;

public class BaseListDiffCallback<T extends ListDiffCallback<T>> extends DiffUtil.ItemCallback<T> {
    @Override
    public boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.theSameAs(newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.equals(newItem);
    }

    @Nullable
    @Override
    public Object getChangePayload(@NonNull T oldItem, @NonNull T newItem) {
        return newItem;
    }
}
