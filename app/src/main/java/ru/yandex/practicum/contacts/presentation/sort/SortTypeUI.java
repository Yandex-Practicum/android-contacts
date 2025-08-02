package ru.yandex.practicum.contacts.presentation.sort;

import androidx.annotation.NonNull;

import ru.yandex.practicum.contacts.presentation.base.ListDiffInterface;

public class SortTypeUI implements ListDiffInterface<SortTypeUI> {

    private final String type;
    private final boolean isSelected;

    public SortTypeUI(@NonNull String type, boolean isSelected) {
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
        return "Выбран тип сортировки: " + type;
    }

    @Override
    public boolean theSameAs(SortTypeUI other) {
        return this.type.equals(other.type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SortTypeUI that = (SortTypeUI) o;

        if (isSelected != that.isSelected) return false;
        return type.equals(that.type);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (isSelected ? 1 : 0);
        return result;
    }
}
