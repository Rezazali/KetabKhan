package com.book.fidibo.adapter.viewHolder;

import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.book.fidibo.R;

public class BookMarkViewHolder extends RecyclerView.ViewHolder {

    public AppCompatImageView img_book;
    public AppCompatImageView img_book_bottom;
    public AppCompatTextView txt_bookTitle;
    public AppCompatTextView txt_publisher;
    public RelativeLayout rel_book;
    public AppCompatButton btn_more;


    public BookMarkViewHolder(@NonNull View itemView) {
        super(itemView);

        img_book = itemView.findViewById(R.id.img_book_library);
        img_book_bottom =(AppCompatImageView) itemView.findViewById(R.id.img_bottom_sheet);
        txt_bookTitle = itemView.findViewById(R.id.txt_titleBook);
        txt_publisher = itemView.findViewById(R.id.txt_publisher);
        rel_book = itemView.findViewById(R.id.rel_book_library);
        btn_more = itemView.findViewById(R.id.btn_more);

    }
}
