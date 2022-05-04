package ru.yandex.practicum.contacts.utils.model;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import ru.yandex.practicum.contacts.R;
import ru.yandex.practicum.contacts.model.ContactType;
import ru.yandex.practicum.contacts.presentation.filter.model.FilterContactType;

public class FilterContactTypeUtils {

    @StringRes
    public static int getStringRes(FilterContactType contactType) {
        switch (contactType) {
            case ALL:
                return R.string.filter_contact_type_all;
            case TELEGRAM:
                return R.string.filter_contact_type_telegram;
            case WHATS_APP:
                return R.string.filter_contact_type_whatsapp;
            case VIBER:
                return R.string.filter_contact_type_viber;
            case SIGNAL:
                return R.string.filter_contact_type_signal;
            case THREEMA:
                return R.string.filter_contact_type_threema;
            case PHONE:
                return R.string.filter_contact_type_phone;
            case EMAIL:
                return R.string.filter_contact_type_email;
            default:
                throw new IllegalArgumentException("Not supported SortType");
        }
    }

    @NonNull
    public static ContactType toContactType(FilterContactType type) {
        switch (type) {
            case TELEGRAM:
                return ContactType.TELEGRAM;
            case WHATS_APP:
                return ContactType.WHATS_APP;
            case VIBER:
                return ContactType.VIBER;
            case SIGNAL:
                return ContactType.SIGNAL;
            case THREEMA:
                return ContactType.THREEMA;
            case PHONE:
                return ContactType.PHONE;
            case EMAIL:
                return ContactType.EMAIL;
            default:
                throw new IllegalArgumentException("Not supported FilterContactType");
        }
    }
}
