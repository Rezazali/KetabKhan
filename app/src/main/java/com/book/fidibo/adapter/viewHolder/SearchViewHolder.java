package com.book.fidibo.adapter.viewHolder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.book.fidibo.R;

public class SearchViewHolder extends RecyclerView.ViewHolder {

    public AppCompatTextView txt_title;
    public AppCompatTextView txt_title1;
    public AppCompatTextView txt_title2;
    AppCompatTextView txt_title3;
    public SearchViewHolder(@NonNull View itemView) {
        super(itemView);

        txt_title = itemView.findViewById(R.id.txt_title_model);
        txt_title.setTextDirection(View.TEXT_DIRECTION_FIRST_STRONG);
 /*       txt_title1 = itemView.findViewById(R.id.appCompatTextView);
        txt_title2 = itemView.findViewById(R.id.appCompatTextView4);*/
    }
}
