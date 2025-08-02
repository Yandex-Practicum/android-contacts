package ru.yandex.practicum.contacts.presentation.main;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ru.yandex.practicum.contacts.model.ContactType;
import ru.yandex.practicum.contacts.model.MergedContact;
import ru.yandex.practicum.contacts.presentation.sort.model.SortType;

public class MainState {

    private final String defaultSortType = SortType.BY_NAME;
    private final Set<ContactType> defaultContactTypes = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(ContactType.values())));

    private List<MergedContact> allContacts = Collections.emptyList();
    private String sortType = defaultSortType;
    private Set<ContactType> contactTypes = new HashSet<>(defaultContactTypes);
    private String query = "";

    @NonNull
    public List<MergedContact> getAllContacts() {
        return allContacts;
    }

    public void setAllContacts(@NonNull List<MergedContact> allContacts) {
        this.allContacts = allContacts;
    }

    @NonNull
    public String getDefaultSortType() {
        return defaultSortType;
    }

    @NonNull
    public String getSortType() {
        return sortType;
    }

    public void setSortType(@NonNull String sortType) {
        this.sortType = sortType;
    }

    @NonNull
    public Set<ContactType> getDefaultContactTypes() {
        return defaultContactTypes;
    }

    @NonNull
    public Set<ContactType> getContactTypes() {
        return contactTypes;
    }

    public void setContactTypes(@NonNull Set<ContactType> contactTypes) {
        this.contactTypes = contactTypes;
    }

    @NonNull
    public String getQuery() {
        return query;
    }

    public void setQuery(@NonNull String query) {
        this.query = query;
    }
}
