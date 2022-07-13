package com.book.fidibo.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.book.fidibo.R;
import com.book.fidibo.activity.BookDetailActivity;
import com.book.fidibo.models.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookByCategoryAdapter extends RecyclerView.Adapter<BookByCategoryViewHolder> {




    ///use interface in adapter



    List<Category> categoryList;
    Context context;
    public BookByCategoryAdapter(List<Category> categoryList, Context context){
        this.categoryList = categoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public BookByCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.book_row, null);

        return new BookByCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookByCategoryViewHolder holder, int position) {


        Category category = categoryList.get(position);
        Log.d("","");

        Picasso.get().load(Uri.parse(category.getBookThumbnailS())).into(holder.img_book);

        holder.img_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BookDetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("data",category);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

}
