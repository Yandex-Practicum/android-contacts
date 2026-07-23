package ru.yandex.practicum.contacts.model;

public enum ContactType {
    TELEGRAM,
    WHATS_APP,
    VIBER,
    SIGNAL,
    THREEMA,
    PHONE,
    EMAIL;

    public static String[] getContactTypes() {
        ContactType[] types = values();
        String[] result = new String[types.length];

        for (int i = 0; i < types.length; i++) {
            result[i] = types[i].name();
        }

        return result;
    }
}


