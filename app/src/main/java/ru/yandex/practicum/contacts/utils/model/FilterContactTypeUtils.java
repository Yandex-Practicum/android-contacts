package ru.yandex.practicum.contacts.utils.model;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import ru.yandex.practicum.contacts.R;
import ru.yandex.practicum.contacts.model.ContactType;
import ru.yandex.practicum.contacts.presentation.filter.model.FilterContactType;

public class FilterContactTypeUtils {

    @StringRes
    public static int getStringRes(String contactType) {
        switch (contactType) {
            case FilterContactType.ALL:
                return R.string.filter_contact_type_all;
            case FilterContactType.TELEGRAM:
                return R.string.filter_contact_type_telegram;
            case FilterContactType.WHATS_APP:
                return R.string.filter_contact_type_whatsapp;
            case FilterContactType.VIBER:
                return R.string.filter_contact_type_viber;
            case FilterContactType.SIGNAL:
                return R.string.filter_contact_type_signal;
            case FilterContactType.THREEMA:
                return R.string.filter_contact_type_threema;
            case FilterContactType.PHONE:
                return R.string.filter_contact_type_phone;
            case FilterContactType.EMAIL:
                return R.string.filter_contact_type_email;
            default:
                throw new IllegalArgumentException("Not supported SortType");
        }
    }

    @NonNull
    public static ContactType toContactType(String type) {
        switch (type) {
            case FilterContactType.TELEGRAM:
                return ContactType.TELEGRAM;
            case FilterContactType.WHATS_APP:
                return ContactType.WHATS_APP;
            case FilterContactType.VIBER:
                return ContactType.VIBER;
            case FilterContactType.SIGNAL:
                return ContactType.SIGNAL;
            case FilterContactType.THREEMA:
                return ContactType.THREEMA;
            case FilterContactType.PHONE:
                return ContactType.PHONE;
            case FilterContactType.EMAIL:
                return ContactType.EMAIL;
            default:
                throw new IllegalArgumentException("Not supported FilterContactType");
        }
    }
}
