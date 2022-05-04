package ru.yandex.practicum.contacts.utils.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import ru.yandex.practicum.contacts.R;
import ru.yandex.practicum.contacts.model.ContactType;
import ru.yandex.practicum.contacts.presentation.filter.model.FilterContactType;
import ru.yandex.practicum.contacts.utils.Constants;

public class ContactTypeUtils {

    @DrawableRes
    public static int getIconRes(@NonNull ContactType type) {
        switch (type) {
            case TELEGRAM:
                return R.drawable.ic_type_telegram;
            case WHATS_APP:
                return R.drawable.ic_type_whatsapp;
            case VIBER:
                return R.drawable.ic_type_viber;
            case SIGNAL:
                return R.drawable.ic_type_signal;
            case THREEMA:
                return R.drawable.ic_type_threema;
            case PHONE:
                return R.drawable.ic_type_phone;
            case EMAIL:
                return R.drawable.ic_type_email;
            default:
                throw new IllegalArgumentException("Not supported type of ContactType");
        }
    }

    public static FilterContactType toFilterContactType(ContactType type) {
        switch (type) {
            case TELEGRAM:
                return FilterContactType.TELEGRAM;
            case WHATS_APP:
                return FilterContactType.WHATS_APP;
            case VIBER:
                return FilterContactType.VIBER;
            case SIGNAL:
                return FilterContactType.SIGNAL;
            case THREEMA:
                return FilterContactType.THREEMA;
            case PHONE:
                return FilterContactType.PHONE;
            case EMAIL:
                return FilterContactType.EMAIL;
            default:
                throw new IllegalArgumentException("Not supported ContactType");
        }
    }

    @Nullable
    public static ContactType parse(String value) {
        switch (value) {
            case Constants.StorageType.TELEGRAM:
                return ContactType.TELEGRAM;
            case Constants.StorageType.WHATSAPP:
                return ContactType.WHATS_APP;
            case Constants.StorageType.VIBER:
                return ContactType.VIBER;
            case Constants.StorageType.SIGNAL:
                return ContactType.SIGNAL;
            case Constants.StorageType.THREEMA:
                return ContactType.THREEMA;
            default:
                return null;
        }
    }
}
