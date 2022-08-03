package com.book.fidibo.activity.uiActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.book.fidibo.R;
import com.book.fidibo.models.Category;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class BottomSheet extends BottomSheetDialogFragment {

    public BottomSheet() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    interface FragmentListener {
        void getView(View view);
    }

    static FragmentListener mFragmentListener;

    public static BottomSheet newInstance(FragmentListener listener) {
        mFragmentListener = listener;
        return new BottomSheet();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Objects.requireNonNull(getDialog()).setOnShowListener(dialog -> {

            BottomSheetDialog d = (BottomSheetDialog) dialog;
            View bottomSheetInternal =
                    d.findViewById(com.google.android.material.R.id.design_bottom_sheet);
            assert bottomSheetInternal != null;
            BottomSheetBehavior.from(bottomSheetInternal).setState(BottomSheetBehavior.STATE_EXPANDED);
        });

        View view = inflater.inflate(R.layout.layout_bottom_sheet, container, false);

        // Trigger the listener callback to return the view back to the activity
        // mFragmentListener.getView(view);  // Not working in all devices

        return inflater.inflate(R.layout.layout_bottom_sheet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // Trigger the listener callback to return the view back to the activity
        mFragmentListener.getView(view);
    }

}
