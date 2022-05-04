package ru.yandex.practicum.contacts.interactor;

import android.text.TextUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import ru.yandex.practicum.contacts.model.Contact;
import ru.yandex.practicum.contacts.model.ContactSource;
import ru.yandex.practicum.contacts.model.MergedContact;
import ru.yandex.practicum.contacts.utils.Constants;
import ru.yandex.practicum.contacts.utils.model.ContactUtils;

public class ContactMerger {

    public List<MergedContact> getMergedContacts(Collection<Contact> contacts, Collection<ContactSource> sources) {
        final Map<String, ContactSource> sourcesMap = sources.stream()
                .collect(Collectors.toMap(ContactSource::getName, Function.identity(), this::resolveConflicts));
        final Map<String, List<Contact>> contactsMap = contacts.stream()
                .filter(contact -> !TextUtils.isEmpty(ContactUtils.getDisplayName(contact)))
                .collect(Collectors.groupingBy(ContactUtils::getDisplayName));
        final List<MergedContact> mergedContacts = contactsMap.entrySet().stream()
                .map(entry -> mergeContact(entry, sourcesMap))
                .collect(Collectors.toList());
        return Collections.unmodifiableList(mergedContacts);
    }

    private MergedContact mergeContact(Map.Entry<String, List<Contact>> entry, Map<String, ContactSource> sources) {
        final List<Contact> contacts = entry.getValue();
        final Contact contact = contacts.get(0);
        final List<String> contactSources = contacts.stream()
                .map(each -> Objects.requireNonNull(sources.get(each.getSource())).getPublicName())
                .distinct()
                .collect(Collectors.toList());
        return new MergedContact(
                contact.getId(),
                contact.getFirstName(),
                contact.getMiddleName(),
                contact.getSurname(),
                ContactUtils.getFirstPhone(contact),
                ContactUtils.getFirstNormalizedPhone(contact),
                ContactUtils.getFirstEmail(contact),
                contactSources,
                contact.getPhotoUri()
        );
    }

    private ContactSource resolveConflicts(ContactSource source1, ContactSource source2) {
        if (Objects.equals(source1.getType(), Constants.StorageType.GOOGLE)) {
            return source1;
        }
        if (Objects.equals(source2.getType(), Constants.StorageType.GOOGLE)) {
            return source2;
        }
        return source1;
    }

}
