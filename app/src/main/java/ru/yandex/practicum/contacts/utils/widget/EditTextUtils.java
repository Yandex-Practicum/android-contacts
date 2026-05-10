package ru.yandex.practicum.contacts.utils.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.function.Consumer;


public class EditTextUtils {

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
