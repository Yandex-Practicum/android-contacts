package ru.yandex.practicum.contacts.utils.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.function.Consumer;

import ru.yandex.practicum.contacts.utils.android.Debouncer;

public class EditTextUtils {

    public static void debounce(EditText editText, Debouncer.OnValueUpdateListener<Editable> listener) {
        final Debouncer<Editable> debouncer = new Debouncer<>(listener);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                debouncer.updateValue(s);
            }
        });
    }

    public static void addTextListener(EditText editText, Consumer<Editable> consumer) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                consumer.accept(s);
            }
        });
    }
}
