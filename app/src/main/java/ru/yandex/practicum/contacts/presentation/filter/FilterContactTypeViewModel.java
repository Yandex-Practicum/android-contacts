package ru.yandex.practicum.contacts.presentation.filter;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import ru.yandex.practicum.contacts.model.ContactType;
import ru.yandex.practicum.contacts.presentation.base.BaseBottomSheetViewModel;
import ru.yandex.practicum.contacts.presentation.filter.model.FilterContactType;
import ru.yandex.practicum.contacts.presentation.filter.model.FilterContactTypeUi;
import ru.yandex.practicum.contacts.utils.model.ContactTypeUtils;
import ru.yandex.practicum.contacts.utils.model.FilterContactTypeUtils;

public class FilterContactTypeViewModel extends BaseBottomSheetViewModel {

    private final UiState uiState = new UiState();
    private final MutableLiveData<List<FilterContactTypeUi>> filterContactTypesLiveDate = new MutableLiveData<>();
    private final MutableLiveData<UiState> uiStateLiveDate = new MutableLiveData<>();

    private Set<ContactType> defaultFilterContactTypes;
    private Set<ContactType> selectedFilterContactTypes;

    public void init(Set<ContactType> defaultFilterContactTypes) {
        this.defaultFilterContactTypes = new HashSet<>(defaultFilterContactTypes);
        this.selectedFilterContactTypes = new HashSet<>(defaultFilterContactTypes);
        updateFilterContactTypes();
        updateUiState();
    }

    public void onFilterTypeItemClick(FilterContactTypeUi filterContactType) {
        updateSelectedContactTypes(filterContactType.getContactType());
        updateFilterContactTypes();
        updateUiState();
    }

    @Override
    public void onApplyClick() {
        uiState.newSelectedContactTypes = selectedFilterContactTypes;
        updateUiState();
    }

    @Override
    public void onResetClick() {
        selectedFilterContactTypes = new HashSet<>(defaultFilterContactTypes);
        updateFilterContactTypes();
        updateUiState();
    }

    public MutableLiveData<List<FilterContactTypeUi>> getFilterContactTypesLiveDate() {
        return filterContactTypesLiveDate;
    }

    public MutableLiveData<UiState> getUiStateLiveDate() {
        return uiStateLiveDate;
    }

    private void updateFilterContactTypes() {
        final List<FilterContactTypeUi> filterContactTypesUi = new ArrayList<>();
        final boolean allSelected = selectedFilterContactTypes.size() == ContactType.values().length;
        filterContactTypesUi.add(new FilterContactTypeUi(FilterContactType.ALL, allSelected));
        final List<FilterContactTypeUi> collect = Arrays.stream(ContactType.values())
                .map(contactType -> new FilterContactTypeUi(
                        ContactTypeUtils.toFilterContactType(contactType),
                        selectedFilterContactTypes.contains(contactType)
                ))
                .collect(Collectors.toList());
        filterContactTypesUi.addAll(collect);
        filterContactTypesLiveDate.setValue(filterContactTypesUi);
    }

    private void updateUiState() {
        uiState.isApplyEnable = !defaultFilterContactTypes.equals(selectedFilterContactTypes) && !selectedFilterContactTypes.isEmpty();
        uiStateLiveDate.setValue(uiState);
    }

    private void updateSelectedContactTypes(FilterContactType type) {
        if (type == FilterContactType.ALL) {
            if (selectedFilterContactTypes.size() == ContactType.values().length) {
                selectedFilterContactTypes.clear();
            } else {
                selectedFilterContactTypes.addAll(Arrays.asList(ContactType.values()));
            }
            return;
        }
        final ContactType contactType = FilterContactTypeUtils.toContactType(type);
        if (selectedFilterContactTypes.contains(contactType)) {
            selectedFilterContactTypes.remove(contactType);
        } else {
            selectedFilterContactTypes.add(contactType);
        }
    }

    static class UiState {
        public boolean isApplyEnable = false;
        public Set<ContactType> newSelectedContactTypes = Collections.emptySet();
    }
}
