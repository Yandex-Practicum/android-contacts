package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffCallback<T> {
    public boolean theSameAs(T type);
    public boolean equals(Object o); /* {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListDiffCallback<?> that = (ListDiffCallback<?>) o;
    }
    */
}
