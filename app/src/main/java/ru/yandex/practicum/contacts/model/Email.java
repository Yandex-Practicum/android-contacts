package ru.yandex.practicum.contacts.model;

import androidx.annotation.NonNull;

public class Email {

    private final String value;
    private final int type;
    private final String label;

    public Email(@NonNull String value, int type, @NonNull String label) {
        this.value = value;
        this.type = type;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public int getType() {
        return type;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        if (type != email.type) return false;
        if (!value.equals(email.value)) return false;
        return label.equals(email.label);
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + type;
        result = 31 * result + label.hashCode();
        return result;
    }
}
