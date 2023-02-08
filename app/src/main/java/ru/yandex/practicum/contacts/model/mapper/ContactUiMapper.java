package ru.yandex.practicum.contacts.model.mapper;

import android.text.TextUtils;

import ru.yandex.practicum.contacts.model.MergedContact;
import ru.yandex.practicum.contacts.presentation.main.ContactUi;
import ru.yandex.practicum.contacts.utils.model.MergedContactUtils;
import ru.yandex.practicum.contacts.utils.model.PhoneUtils;

public class ContactUiMapper {

    public ContactUi map(MergedContact contact) {
        String displayName = (contact.getFirstName() + " " + contact.getSurname()).trim();
        String phone = PhoneUtils.format(contact.getPhone());
        if (TextUtils.isEmpty(displayName)) {
            if (!TextUtils.isEmpty(phone)) {
                displayName = phone;
                phone = "";
            } else {
                displayName = contact.getEmail();
            }
        }
        return new ContactUi(
                displayName,
                phone,
                contact.getPhotoUri(),
                MergedContactUtils.getContactTypes(contact)
        );
    }
}
