package com.book.fidibo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.book.fidibo.R;
import com.book.fidibo.adapter.viewHolder.CategoryViewHolder;
import com.book.fidibo.models.Category;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {



    ///use interface in adapter

    List<Category> categoryList;
    Context context;
    UserOnClickListener userOnClickListener;
    public CategoryAdapter(List<Category> categoryList,Context context, UserOnClickListener userOnClickListener){
        this.categoryList = categoryList;
        this.context = context;
        this.userOnClickListener = userOnClickListener;
    }


    public interface UserOnClickListener{
        void Category(Category category);
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.listbook_row,null);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {



        Log.d("","");
        Category category = categoryList.get(position);
        holder.txt_bookTitle.setText(category.getBookTitle());
        holder.txt_publisher.setText(category.getBookPublisher());
        Picasso.get().load(category.getBookThumbnailS()).into(holder.img_book);


        holder.rel_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userOnClickListener.Category(category);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

}
