package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

    public class BaseListDiffCallback <T extends ListDiffCallback<T>> extends  DiffUtil.ItemCallback<T>  {
        @Override
        public boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {
            return false;
        }
        @Nullable
        @Override
        public Object getChangePayload(@NonNull T oldIteam,@NonNull T newIteam){
            return newIteam;
        }
    }

