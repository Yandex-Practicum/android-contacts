package ru.yandex.practicum.contacts.presentation.sort;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import ru.yandex.practicum.contacts.presentation.base.BaseBottomSheetViewModel;
import ru.yandex.practicum.contacts.presentation.sort.model.SortType;

public class SortViewModel extends BaseBottomSheetViewModel {

    private final UiState uiState = new UiState();
    private final MutableLiveData<List<SortTypeUI>> sortTypesLiveDate = new MutableLiveData<>();
    private final MutableLiveData<UiState> uiStateLiveDate = new MutableLiveData<>();

    private SortType defaultSortType;
    private SortType selectedSortType;

    public void init(SortType defaultSortType) {
        this.defaultSortType = defaultSortType;
        this.selectedSortType = defaultSortType;
        updateSortTypes();
        updateUiState();
    }

    public void onSortTypeItemClick(SortTypeUI sortType) {
        selectedSortType = sortType.getSortType();
        updateSortTypes();
        updateUiState();
    }

    @Override
    public void onApplyClick() {
        uiState.newSelectedSortType = selectedSortType;
        updateUiState();
    }

    @Override
    public void onResetClick() {
        selectedSortType = defaultSortType;
        updateSortTypes();
        updateUiState();
    }

    public MutableLiveData<List<SortTypeUI>> getSortTypesLiveDate() {
        return sortTypesLiveDate;
    }

    public MutableLiveData<UiState> getUiStateLiveDate() {
        return uiStateLiveDate;
    }

    // Метод создает элементы интерфейса для отображения списка в диалоге сортировки
    private void updateSortTypes() {
        // Все возможные типы сортировок
        final SortType[] sortTypes = SortType.values();

        // TODO Задача 2: получить список элементов класса SortTypeUI,
        // выбранный элемент хранится в переменной selectedSortType.

        // Отдаем список для отображения в диалоге
        sortTypesLiveDate.setValue(sortTypesUi);
    }

    private void updateUiState() {
        uiState.isApplyEnable = defaultSortType != selectedSortType;
        uiStateLiveDate.setValue(uiState);
    }

    static class UiState {
        public boolean isApplyEnable = false;
        @Nullable public SortType newSelectedSortType = null;
    }
}
