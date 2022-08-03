package com.book.fidibo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.book.fidibo.R;
import com.book.fidibo.activity.BookDetailActivity;
import com.book.fidibo.adapter.viewHolder.ShowAllBookViewHolder;
import com.book.fidibo.models.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShowAllBookAdapter extends RecyclerView.Adapter<ShowAllBookViewHolder> {

    Context context;
    List<Category>categoryList;
    public ShowAllBookAdapter(List<Category>categoryList,Context context){
        this.context = context;
        this.categoryList = categoryList;
    }


    @NonNull
    @Override
    public ShowAllBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.book_more_info_model,null);
        return new ShowAllBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAllBookViewHolder holder, int position) {

        Category category = categoryList.get(position);
        holder.txt_title.setText(category.getBookTitle());
        holder.txt_publisher.setText(category.getBookPublisher());

        Picasso.get().load(category.getBookThumbnailS()).into(holder.img_book);
        holder.rel_book_more_info.setOnClickListener(new View.OnClickListener() {
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
