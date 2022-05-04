package ru.yandex.practicum.contacts.model;

import androidx.annotation.NonNull;

public class PhoneNumber {

    private final String value;
    private final int type;
    private final String label;
    private final String normalizedNumber;

    public PhoneNumber(@NonNull String value, int type, @NonNull String label, @NonNull String normalizedNumber) {
        this.value = value;
        this.type = type;
        this.label = label;
        this.normalizedNumber = normalizedNumber;
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

    public String getNormalizedNumber() {
        return normalizedNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneNumber that = (PhoneNumber) o;

        if (type != that.type) return false;
        if (!value.equals(that.value)) return false;
        if (!label.equals(that.label)) return false;
        return normalizedNumber.equals(that.normalizedNumber);
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + type;
        result = 31 * result + label.hashCode();
        result = 31 * result + normalizedNumber.hashCode();
        return result;
    }
}
