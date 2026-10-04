package ru.yandex.practicum.contacts.presentation.filter.model;

import androidx.annotation.NonNull;
import java.util.Objects;

public class FilterContactTypeUi {

    private final FilterContactType contactType;
    private final boolean selected;

    public FilterContactTypeUi(FilterContactType contactType, boolean selected) {
        this.contactType = contactType;
        this.selected = selected;
    }

    public FilterContactType getContactType() {
        return contactType;
    }

    public boolean isSelected() {
        return selected;
    }

    // Находится строго НАД методом equals(Object o)
    @Override
    public boolean theSameAs(@NonNull FilterContactTypeUi newItem) {
        return this.contactType == newItem.getContactType();
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
        return Objects.hash(contactType, selected);
    }
}
