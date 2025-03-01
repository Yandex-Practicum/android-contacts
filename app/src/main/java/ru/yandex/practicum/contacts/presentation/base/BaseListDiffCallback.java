package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

//Шаг 3. Дженерик-класс
//Создайте новый публичный класс BaseListDiffCallback.
//Класс BaseListDiffCallback должен быть дженерик-классом с ограничением параметра типа на обязательную реализацию интерфейса ListDiffInterface<>. В качестве параметра типа у интерфейса указывается такое же имя, что и у класса.
//Класс наследуется от DiffUtil.ItemCallback<>, но в качестве его параметра типа указывается дженерик-тип, но уже без ограничения.
//Класс должен переопределять те же самые методы.
//Все типы данных, передаваемые в переопределяемые методы, должны быть заменены на дженерик-тип.
public class BaseListDiffCallback<T extends ListDiffInterface<T>> extends DiffUtil.ItemCallback<T> {
    //Реализацию метода areItemsTheSame() необходимо заменить
    //на реализацию с использованием метода theSameAs() интерфейса ListDiffInterface.
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
