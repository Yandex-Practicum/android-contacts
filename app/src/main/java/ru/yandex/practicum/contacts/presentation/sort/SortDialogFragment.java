package ru.yandex.practicum.contacts.presentation.sort;

import android.os.Bundle;
import android.view.View;

import java.util.List;
import java.util.Objects;

import ru.yandex.practicum.contacts.R;
import ru.yandex.practicum.contacts.presentation.base.BaseBottomSheetDialogFragment;
import ru.yandex.practicum.contacts.presentation.sort.model.SortType;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;

public class SortDialogFragment extends BaseBottomSheetDialogFragment<SortViewModel> {

    public static final String REQUEST_KEY = "REQUEST_KEY_SORT";
    public static final String ARG_SELECTED_SORT_TYPE = "ARG_SELECTED_SORT_TYPE";

    private SortTypeAdapter adapter;

    private SortDialogFragment() {
        super(SortViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iniViewModel();
        adapter = new SortTypeAdapter((sortType) -> {
            viewModel.onSortTypeItemClick(sortType);
            viewModel.log(sortType.createLogMessage());
        });
        binding.recycler.setAdapter(adapter);

        final DividerItemDecoration decoration = new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL);
        decoration.setDrawable(Objects.requireNonNull(ContextCompat.getDrawable(requireActivity(), R.drawable.item_decoration_16dp)));
        binding.recycler.addItemDecoration(decoration);

        viewModel.getSortTypesLiveDate().observe(this, this::updateSortTypes);
        viewModel.getUiStateLiveDate().observe(this, this::updateState);
    }

    private void iniViewModel() {
        final String defaultSortType = from(getArguments());
        viewModel.init(defaultSortType);
    }

    private void updateSortTypes(List<SortTypeUI> sortTypes) {
        adapter.setItems(sortTypes);
    }

    private void updateState(SortViewModel.UiState state) {
        binding.applyButton.setEnabled(state.isApplyEnable);

        if (state.newSelectedSortType != null) {
            getParentFragmentManager().setFragmentResult(REQUEST_KEY, createBundle(state.newSelectedSortType));
            dismiss();
        }
    }

    public static SortDialogFragment newInstance(String selectedSortType) {
        final SortDialogFragment fragment = new SortDialogFragment();
        fragment.setArguments(createBundle(selectedSortType));
        return fragment;
    }

    public static String from(@Nullable Bundle bundle) {
        if (bundle == null) {
            return SortType.BY_NAME;
        }
        return bundle.getString(ARG_SELECTED_SORT_TYPE);
    }

    private static Bundle createBundle(String sortType) {
        final Bundle bundle = new Bundle();
        bundle.putString(ARG_SELECTED_SORT_TYPE, sortType);
        return bundle;
    }
}
