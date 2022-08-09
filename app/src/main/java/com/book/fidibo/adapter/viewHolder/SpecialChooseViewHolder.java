package com.book.fidibo.adapter.viewHolder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.book.fidibo.R;

public class SpecialChooseViewHolder extends RecyclerView.ViewHolder {


    public AppCompatImageView img_book;

    public SpecialChooseViewHolder(@NonNull View itemView) {
        super(itemView);

        img_book = itemView.findViewById(R.id.img_book_category);
    }
}
