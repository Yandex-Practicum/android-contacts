package ru.yandex.practicum.contacts.presentation.base;

import java.util.ArrayList;
import java.util.List;

import ru.yandex.practicum.contacts.model.ContactType;
import ru.yandex.practicum.contacts.presentation.main.ContactUi;
import ru.yandex.practicum.contacts.presentation.sort.SortTypeUI;
import ru.yandex.practicum.contacts.presentation.sort.model.SortType;

public class MyClass implements ListDiffInterface<MyClass> {
    private int id;
    private String name;

    public MyClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        MyClass myClass = (MyClass) object;
        return this.id == myClass.id && this.name.equals(myClass.name);
    }

    public boolean theSameAs(MyClass tobject) {
        if (tobject == null) {
            return false;
        }
        return this.id == tobject.id && this.name.equals(tobject.name);
    }
}
