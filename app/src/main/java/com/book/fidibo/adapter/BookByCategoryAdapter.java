package com.book.fidibo.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.book.fidibo.R;
import com.book.fidibo.activity.BookDetailActivity;
import com.book.fidibo.adapter.viewHolder.BookByCategoryViewHolder;
import com.book.fidibo.models.Book;
import com.book.fidibo.models.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookByCategoryAdapter extends RecyclerView.Adapter<BookByCategoryViewHolder> {




    ///use interface in adapter



    List<Book> categoryList;
    Context context;
    UserOnClickListener onClickListener;
    public BookByCategoryAdapter(List<Book> categoryList, Context context,UserOnClickListener onClickListener){
        this.categoryList = categoryList;
        this.onClickListener = onClickListener;
        this.context = context;
    }

    public interface UserOnClickListener{
        void onClick(Book book);
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


        Book book = categoryList.get(position);
        Log.d("","");

        Picasso.get().load(Uri.parse(book.getBookThumbnailS())).into(holder.img_book);

        holder.img_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                onClickListener.onClick(book);

            /*   *//* ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,view,"myImage");*//*
                Intent intent = new Intent(context, BookDetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("dataa",book);
                context.startActivity(intent);*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

}
