package ru.yandex.practicum.contacts.utils.model;

import android.text.TextUtils;

import ru.yandex.practicum.contacts.model.Contact;

public class ContactUtils {

    public static String getDisplayName(Contact contact) {
        final String fullName = getFullName(contact);
        if (!TextUtils.isEmpty(fullName)) {
            return fullName;
        }
        final String phone = PhoneUtils.format(getFirstPhone(contact));
        if (!TextUtils.isEmpty(phone)) {
            return phone;
        }
        final String email = getFirstEmail(contact);
        if (!TextUtils.isEmpty(email)) {
            return email;
        }
        return "";
    }

    public static String getFullName(Contact contact) {
        final String firstMiddle = (contact.getFirstName() + " " + contact.getMiddleName()).trim();
        final String suffixComma = TextUtils.isEmpty(contact.getSuffix()) ? "" : ", " + contact.getSuffix();
        return (contact.getPrefix() + " " + contact.getSurname() + " " + firstMiddle + suffixComma).trim();
    }

    public static String getFirstPhone(Contact contact) {
        return !contact.getPhoneNumbers().isEmpty() ? contact.getPhoneNumbers().get(0).getValue().trim() : "";
    }

    public static String getFirstNormalizedPhone(Contact contact) {
        return !contact.getPhoneNumbers().isEmpty() ? contact.getPhoneNumbers().get(0).getNormalizedNumber().trim() : "";
    }

    public static String getFirstEmail(Contact contact) {
        return !contact.getEmails().isEmpty() ? contact.getEmails().get(0).getValue().trim() : "";
    }
}
