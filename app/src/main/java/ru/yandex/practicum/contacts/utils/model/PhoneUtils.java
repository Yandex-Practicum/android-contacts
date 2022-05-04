package ru.yandex.practicum.contacts.utils.model;

import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;

import java.util.Locale;

public class PhoneUtils {

    public static String format(String phone) {
        final String formattedPhone = PhoneNumberUtils.formatNumber(phone, Locale.getDefault().getISO3Country());
        return TextUtils.isEmpty(formattedPhone) ? phone : formattedPhone;
    }
}
