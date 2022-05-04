package ru.yandex.practicum.contacts.utils.java;

import android.os.Handler;
import android.os.Looper;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ThreadUtils {

    public static <T> void runAsync(Supplier<T> supplier, Consumer<T> consumer) {
        final Handler handler = new Handler(Looper.getMainLooper());
        new Thread() {
            @Override
            public void run() {
                final T value = supplier.get();
                handler.post(() -> consumer.accept(value));
            }
        }.start();
    }

    public static void runAsync(Runnable runnable) {
        new Thread(runnable).start();
    }
}
