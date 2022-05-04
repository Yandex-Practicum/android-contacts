package ru.yandex.practicum.contacts.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.util.List;

import ru.yandex.practicum.contacts.R;

public abstract class StackImageView<T> extends FrameLayout {

    protected static final int DEFAULT_COUNT = 3;
    protected static final int DEFAULT_ICON_SIZE_RES = R.dimen.stack_image_view_icon_size;
    protected static final int DEFAULT_BORDER_SIZE_RES = R.dimen.stack_image_view_icon_border;
    protected static final int DEFAULT_ICON_OFFSET_RES = R.dimen.stack_image_view_icon_offset;

    protected int itemsCount;
    protected int maxCount;
    protected int iconSize;
    protected int borderSize;
    protected int iconOffset;

    private ImageView[] icons;

    public StackImageView(Context context) {
        this(context, null, 0);
    }

    public StackImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StackImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyAttrs(attrs);
        init();
    }

    public StackImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        applyAttrs(attrs);
        init();
    }

    private void applyAttrs(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.StackImageView);

        maxCount = a.getInteger(R.styleable.StackImageView_iconsCount, DEFAULT_COUNT);
        iconSize = a.getDimensionPixelSize(R.styleable.StackImageView_iconItemSize,
                getResources().getDimensionPixelSize(DEFAULT_ICON_SIZE_RES));
        borderSize = a.getDimensionPixelSize(R.styleable.StackImageView_borderSize,
                getResources().getDimensionPixelSize(DEFAULT_BORDER_SIZE_RES));
        iconOffset = a.getDimensionPixelSize(R.styleable.StackImageView_iconOffset,
                getResources().getDimensionPixelSize(DEFAULT_ICON_OFFSET_RES));

        a.recycle();

        if (maxCount <= 0) {
            throw new IllegalStateException("icons_count must be greater than zero");
        }
    }

    private void init() {
        icons = new ImageView[maxCount];
        for (int i = maxCount - 1; i >= 0; i--) {
            ImageView view = new ImageView(getContext());

            FrameLayout.LayoutParams layoutParams = new LayoutParams(iconSize, iconSize);
            layoutParams.leftMargin = iconOffset * i;
            view.setLayoutParams(layoutParams);

            view.setVisibility(GONE);
            view.setBackgroundResource(R.drawable.bg_image_view_borger);

            addView(view);
            icons[i] = view;
        }
    }

    public void setData(List<T> items) {
        itemsCount = items.size();
        int size = Math.min(maxCount, itemsCount);

        for (int i = 0; i < size; i++) {
            ImageView icon = icons[i];
            icon.setVisibility(VISIBLE);

            T item = items.get(i);
            if (i < size - 1 || size == itemsCount) {
                loadItem(item, icon);
            } else {
                loadLastItem(item, icon);
            }
        }

        if (size < maxCount) {
            for (int i = size; i < maxCount; i++) {
                icons[i].setVisibility(GONE);
            }
        }
    }

    public abstract void loadItem(T item, @NonNull ImageView icon);

    public void loadLastItem(T item, @NonNull ImageView icon) {
        loadItem(item, icon);
    }
}
