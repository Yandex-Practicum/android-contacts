package ru.yandex.practicum.contacts.presentation.sort;

import androidx.annotation.NonNull;

import ru.yandex.practicum.contacts.presentation.base.ListDiffInterface;
import ru.yandex.practicum.contacts.presentation.sort.model.SortType;

public class SortTypeUI implements ListDiffInterface<SortTypeUI> {

    private final SortType sortType;
    private final boolean selected;

    public SortTypeUI(@NonNull SortType sortType, boolean selected) {
        this.sortType = sortType;
        this.selected = selected;
    }

    public SortType getSortType() {
        return sortType;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public boolean theSameAs(ListDiffInterface<SortTypeUI> t) {
        return this == t;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public boolean theSameAs(SortTypeUI sortTypeUI) {
        return ListDiffInterface.super.theSameAs(sortTypeUI);
    }

    @Override
    public int hashCode() {
        int result = sortType.hashCode();
        result = 31 * result + (selected ? 1 : 0);
        return result;
    }
}
