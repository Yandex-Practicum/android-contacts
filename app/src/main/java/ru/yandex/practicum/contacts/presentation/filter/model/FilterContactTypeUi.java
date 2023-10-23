package ru.yandex.practicum.contacts.presentation.filter.model;

import androidx.annotation.NonNull;

import ru.yandex.practicum.contacts.presentation.base.ListDiffInterface;

public class FilterContactTypeUi implements ListDiffInterface<FilterContactTypeUi> {
    // 2 шаг унаследовать интерфейс
    private final FilterContactType contactType;
    private final boolean selected;

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
    // 2 шаг  реализовать метод theSameAs
    @Override
    public  boolean theSameAs(FilterContactTypeUi fu) {
        return this.getContactType() == fu.getContactType();
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
