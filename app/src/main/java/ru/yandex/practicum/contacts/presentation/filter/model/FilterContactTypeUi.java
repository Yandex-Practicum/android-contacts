package ru.yandex.practicum.contacts.presentation.filter.model;

import androidx.annotation.NonNull;

import ru.yandex.practicum.contacts.presentation.base.ListDiffInterface;

public class FilterContactTypeUi implements ListDiffInterface<FilterContactTypeUi> {

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


    @Override
    public int hashCode() {
        int result = contactType.hashCode();
        result = 31 * result + (selected ? 1 : 0);
        return result;
    }

    @Override
    public boolean theSameAs(FilterContactTypeUi filterContactTypeUi) {
        return this.getContactType() == filterContactTypeUi.getContactType();
    }
}
