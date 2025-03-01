package ru.yandex.practicum.contacts.presentation.filter.model;

import androidx.annotation.NonNull;

import ru.yandex.practicum.contacts.presentation.base.ListDiffInterface;

//Шаг 2. Реализация интерфейса
//Добавьте каждому из классов реализацию интерфейса
public class FilterContactTypeUi implements ListDiffInterface<FilterContactTypeUi> {

    private final FilterContactType contactType;
    private final boolean selected;

    //Шаг 2. Реализация интерфейса
    //В каждом из классов реализуйте недостающий метод theSameAs()
    @Override
    public boolean theSameAs(FilterContactTypeUi filterContactTypeUi) {
        return this.getContactType() == filterContactTypeUi.getContactType();
    }

    public FilterContactTypeUi(@NonNull FilterContactType contactType, boolean selected) {
        this.contactType = contactType;
        this.selected = selected;
    }

    public FilterContactType getContactType() {
        return contactType;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilterContactTypeUi that = (FilterContactTypeUi) o;

        if (selected != that.selected) return false;
        return contactType == that.contactType;
    }

    @Override
    public int hashCode() {
        int result = contactType.hashCode();
        result = 31 * result + (selected ? 1 : 0);
        return result;
    }
}
