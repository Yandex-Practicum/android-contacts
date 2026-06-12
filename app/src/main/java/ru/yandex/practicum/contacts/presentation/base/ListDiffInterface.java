package ru.yandex.practicum.contacts.presentation.base;

/**
 * Интерфейс для сравнения объектов.
 *
 * @param <T> тип данных объекта, который будет использоваться в методе theSameAs()
 */
public interface ListDiffInterface<T> {

    /**
     * Проверяет, является ли текущий объект идентичным переданному объекту того же типа.
     *
     * @param other объект того же типа T для сравнения
     * @return true, если объекты идентичны, false в противном случае
     */
    boolean theSameAs(T other);

    /**
     * Стандартный метод сравнения объектов, унаследованный от класса Object.
     * Должен быть реализован классами, реализующими этот интерфейс.
     *
     * @param obj объект типа Object для сравнения
     * @return true, если объекты считаются равными, false в противном случае
     */
    @Override
    boolean equals(Object obj);
}
