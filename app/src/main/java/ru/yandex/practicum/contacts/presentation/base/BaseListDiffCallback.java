package ru.yandex.practicum.contacts.presentation.base;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback <T extends ListDiffInterface> extends DiffUtil.ItemCallback<T> implements ListDiffInterface<BaseListDiffCallback> {
    /*public boolean theSameAs(T item) {
        return this.hashCode() == item.hashCode();
    }*/
    //Ожидал, что закомментированная функция уже проглотит BaseListDiffCallback, но нет.
    //Дописал явную: theSameAs(BaseListDiffCallback item)
    public boolean areContentsTheSame(T item) {
        return this.equals(item);
    }
    @Override
    public boolean areContentsTheSame(T newItem,T oldItem) {
        return areContentsTheSame(newItem);
    }
    @Override
    public boolean areItemsTheSame(T newItem,T oldItem) {
        return areContentsTheSame(newItem);
    }

    @Override
    public boolean theSameAs(BaseListDiffCallback item) {
        return this.hashCode() == item.hashCode();
    }

}
