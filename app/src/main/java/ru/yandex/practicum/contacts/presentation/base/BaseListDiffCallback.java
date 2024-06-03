package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback<BaseListDiffCallback> extends DiffUtil.ItemCallback<BaseListDiffCallback>  implements ListDiffInterface<BaseListDiffCallback>{

      @Override
    public boolean areItemsTheSame(@NonNull BaseListDiffCallback oldItem, @NonNull BaseListDiffCallback newItem) {
       //return false;
       return theSameAs((BaseListDiffCallback) newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull BaseListDiffCallback oldItem, @NonNull BaseListDiffCallback newItem) {
        return false;
    }

    @Override
    public boolean theSameAs(BaseListDiffCallback baseListDiffCallback) {
        return false;
    }
}
