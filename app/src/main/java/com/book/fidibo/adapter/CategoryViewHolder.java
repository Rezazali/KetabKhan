package com.book.fidibo.adapter;

import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.book.fidibo.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    AppCompatImageView img_book;
    AppCompatTextView txt_bookTitle;
    AppCompatTextView txt_publisher;
    RelativeLayout rel_book;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        img_book = itemView.findViewById(R.id.img_book);
        txt_bookTitle = itemView.findViewById(R.id.txt_titleBook);
        txt_publisher = itemView.findViewById(R.id.txt_publisher);
        rel_book = itemView.findViewById(R.id.rel_book);
    }
}
