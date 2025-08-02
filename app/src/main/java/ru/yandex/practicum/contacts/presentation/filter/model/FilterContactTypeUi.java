package ru.yandex.practicum.contacts.presentation.filter.model;

import androidx.annotation.NonNull;

import ru.yandex.practicum.contacts.presentation.base.ListDiffInterface;

public class FilterContactTypeUi implements ListDiffInterface<FilterContactTypeUi> {

    private final String type;
    private final boolean isSelected;

    public FilterContactTypeUi(@NonNull String type, boolean isSelected) {
        this.type = type;
        this.isSelected = isSelected;
    }

    public String getType() {
        return type;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public String createLogMessage() {
        return "Выбран фильтр: " + type;
    }

    @Override
    public boolean theSameAs(FilterContactTypeUi other) {
        return this.type.equals(other.type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilterContactTypeUi)) return false;

        FilterContactTypeUi that = (FilterContactTypeUi) o;

        return isSelected == that.isSelected && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (isSelected ? 1 : 0);
        return result;
    }
}
