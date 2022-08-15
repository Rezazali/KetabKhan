package com.book.fidibo.customeview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class PersianTextViewLigth extends AppCompatTextView {

    public void setFont(@NonNull Context context){
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "font/IRANSansMobile_Light.ttf");
        setTypeface(typeface);

    }

    public PersianTextViewLigth(@NonNull Context context) {
        super(context);
        setFont(context);
    }

    public PersianTextViewLigth(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFont(context);

    }

    public PersianTextViewLigth(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);

    }
}
