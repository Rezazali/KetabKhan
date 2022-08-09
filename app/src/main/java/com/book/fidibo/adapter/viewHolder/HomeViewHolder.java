package com.book.fidibo.adapter.viewHolder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.book.fidibo.R;

public class HomeViewHolder extends RecyclerView.ViewHolder {

    public AppCompatImageView img_book_library;
    public AppCompatImageView img_book_bottom;
    public AppCompatTextView txt_bookTitle;
    public AppCompatTextView txt_bottom;
    public AppCompatTextView txt_publisher;
    public RelativeLayout rel_book_library;
    public AppCompatButton btn_more;

    public AppCompatImageView img_book;


    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);

        img_book = itemView.findViewById(R.id.img_book_category);



        img_book_library = itemView.findViewById(R.id.img_book_library);
        img_book_bottom = itemView.findViewById(R.id.img_bottom_sheet);
        txt_bookTitle = itemView.findViewById(R.id.txt_titleBook);
        txt_bottom = itemView.findViewById(R.id.txt_title_bottom_sheet);
        txt_publisher = itemView.findViewById(R.id.txt_publisher);
        rel_book_library = itemView.findViewById(R.id.rel_book_library);
        btn_more = itemView.findViewById(R.id.btn_more);
    }


}
