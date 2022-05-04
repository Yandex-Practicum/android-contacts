package ru.yandex.practicum.contacts.model;

import androidx.annotation.NonNull;

public class ContactSource {

    private final String name;
    private final String type;
    private final String publicName;

    public ContactSource(@NonNull String name, @NonNull String type, @NonNull String publicName) {
        this.name = name;
        this.type = type;
        this.publicName = publicName;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPublicName() {
        return publicName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactSource that = (ContactSource) o;

        if (!name.equals(that.name)) return false;
        if (!type.equals(that.type)) return false;
        return publicName.equals(that.publicName);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + publicName.hashCode();
        return result;
    }
}
