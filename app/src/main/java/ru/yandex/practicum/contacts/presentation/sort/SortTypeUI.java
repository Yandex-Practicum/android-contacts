package ru.yandex.practicum.contacts.presentation.sort;

import ru.yandex.practicum.contacts.presentation.base.ListDiffInterface;
import ru.yandex.practicum.contacts.presentation.sort.model.SortType;

public record SortTypeUI(SortType sortType,
                         boolean selected) implements ListDiffInterface<SortTypeUI> {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SortTypeUI that = (SortTypeUI) o;

        if (selected != that.selected) return false;
        return sortType == that.sortType;
    }

    public boolean theSameAs(SortTypeUI other) {
        return this.sortType == other.sortType;
    }
}
