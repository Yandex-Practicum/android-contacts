package ru.yandex.practicum.contacts.utils.android;

import android.database.Cursor;

public class CursorUtils {

    public static String getString(Cursor cursor, String key) {
        final int index = cursor.getColumnIndex(key);
        if (index >= 0) {
            final String string = cursor.getString(index);
            return string != null ? string : "";
        } else {
            return "";
        }
    }

    public static int getInteger(Cursor cursor, String key) {
        final int index = cursor.getColumnIndex(key);
        if (index >= 0) {
            return cursor.getInt(index);
        } else {
            return -1;
        }
    }
}
