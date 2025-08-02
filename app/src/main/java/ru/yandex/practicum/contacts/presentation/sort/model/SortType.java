package ru.yandex.practicum.contacts.presentation.sort.model;

public class SortType {

    public static final String BY_NAME = "by_name";
    public static final String BY_NAME_REVERSED = "by_name_reversed";
    public static final String BY_SURNAME = "by_surname";
    public static final String BY_SURNAME_REVERSED = "by_surname_reversed";

    public static String[] values() {
        return new String[]{BY_NAME, BY_NAME_REVERSED, BY_SURNAME, BY_SURNAME_REVERSED};
    }
}
