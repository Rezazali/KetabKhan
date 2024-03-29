package com.book.fidibo.customeview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class PersianTextView extends AppCompatTextView {

    private void setFont(@NonNull Context context){
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "font/iran_sans.ttf");
        setTypeface(typeface);
    }


    public PersianTextView(@NonNull Context context) {
        super(context);
        setFont(context);
    }

    public PersianTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public PersianTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }
}
