package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

/*
Шаг 3. Дженерик-класс
        Класс BaseListDiffCallback должен быть дженерик-классом с ограничением параметра типа на
        обязательную реализацию интерфейса ListDiffInterface<>.
        В качестве параметра типа у интерфейса указывается такое же имя, что и у класса.
        !!!!!!!!!!!!!!!!!!!!!!!!!
        */
public class BaseListDiffCallback <T extends ListDiffInterface<T> >  extends DiffUtil.ItemCallback<T> {
    /*public abstract boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem);
    public boolean theSameAs(SortTypeUI typeObj){ return ( this.getSortType() == typeObj.getSortType() );  }
    }*/
    @Override
    public boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.theSameAs(newItem);
    }
    @Override
    public  boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem){
        return oldItem.equals(newItem);
    }
}
