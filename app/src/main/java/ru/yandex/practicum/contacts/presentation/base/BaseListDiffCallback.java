package ru.yandex.practicum.contacts.presentation.base;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback<T extends ListDiffInterface<T> > extends DiffUtil.ItemCallback<T> {
    @Override
    public boolean areItemsTheSame(@NonNull T t, @NonNull T t1) {
        return t.theSameAs(t1);
    }

    @Override
    public boolean areContentsTheSame(@NonNull T t, @NonNull T t1) {
        return t.equals(t1);
    }

    @Nullable
    @Override
    public Object getChangePayload(@NonNull T t, @NonNull T t1) {
        return t1;
    }
}
