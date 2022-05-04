package ru.yandex.practicum.contacts.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import ru.yandex.practicum.contacts.model.ContactType;
import ru.yandex.practicum.contacts.utils.model.ContactTypeUtils;

public class ContactTypeImageView extends StackImageView<ContactType> {

    public ContactTypeImageView(Context context) {
        super(context);
    }

    public ContactTypeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ContactTypeImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ContactTypeImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void loadItem(ContactType item, @NonNull ImageView icon) {
        int iconRes = ContactTypeUtils.getIconRes(item);
        icon.setImageResource(iconRes);
    }
}
