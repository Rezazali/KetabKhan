package com.book.fidibo.adapter.viewHolder;

import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.book.fidibo.R;

public class ShowAllBookViewHolder extends RecyclerView.ViewHolder {

    public AppCompatImageView img_book;
    public AppCompatTextView txt_title;
    public AppCompatTextView txt_publisher;
    public RelativeLayout rel_book_more_info;
    public ShowAllBookViewHolder(@NonNull View itemView) {
        super(itemView);

        img_book = itemView.findViewById(R.id.img_book_more_info);
        txt_title = itemView.findViewById(R.id.txt_titleBook_more_info);
        txt_publisher = itemView.findViewById(R.id.txt_publisher_more_info);
        rel_book_more_info = itemView.findViewById(R.id.rel_book_more_info);
    }
}
