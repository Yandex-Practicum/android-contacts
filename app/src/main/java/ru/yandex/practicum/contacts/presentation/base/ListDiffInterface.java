package ru.yandex.practicum.contacts.presentation.base;

import java.util.Objects;

public interface ListDiffInterface<T> {
    default boolean theSameAs(T t){
        //return boolean;
        return (boolean) t;
    }

    @Override
    default boolean equals(Objects o){
        if (this == o){
            return true;
        }
        else{
            return false;
        }
    }
}
