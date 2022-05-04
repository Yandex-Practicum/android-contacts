package ru.yandex.practicum.contacts.utils.android;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

public class Debouncer<T> {

    private static final int MESSAGE_ID = 1;
    private static final int DELAY = 500;

    private final OnValueUpdateListener<T> listener;

    public Debouncer(OnValueUpdateListener<T> listener) {
        this.listener = listener;
    }

    @SuppressWarnings("unchecked")
    private final Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message message) {
            if (message.what == MESSAGE_ID) {
                listener.onValueUpdate((T) message.obj);
                return;
            }
            super.handleMessage(message);
        }
    };

    public void updateValue(T value) {
        final Message message = Message.obtain(handler, MESSAGE_ID, value);
        handler.removeMessages(MESSAGE_ID);
        handler.sendMessageDelayed(message, DELAY);
    }

    @FunctionalInterface
    public interface OnValueUpdateListener<T> {
        void onValueUpdate(T value);
    }
}
