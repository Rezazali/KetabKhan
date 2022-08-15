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
import com.book.fidibo.activity.PdfBookActivity;
import com.book.fidibo.adapter.viewHolder.BookMarkViewHolder;
import com.book.fidibo.models.BookMark;
import com.book.fidibo.models.Category;
import com.book.fidibo.models.Shelf;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookMarkAdapter extends RecyclerView.Adapter<BookMarkViewHolder> {


    List<BookMark>bookMarkList;
    Context context;
    Category category;
    public BookMarkAdapter(List<BookMark>bookMarkList,Context context){
        this.bookMarkList = bookMarkList;
        this.context = context;
        category = new Category();
    }


    @NonNull
    @Override
    public BookMarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.book_library_model,null);
        return new BookMarkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookMarkViewHolder holder, int position) {
        BookMark bookMark = bookMarkList.get(position);

        holder.txt_bookTitle.setText(bookMark.getBookTitle());
        holder.txt_publisher.setText(bookMark.getBookPublisher());
        Picasso.get().load(bookMark.getBookThumbnailS()).into(holder.img_book);

        holder.rel_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                category.setId(bookMark.getId());
                category.setBookTitle(bookMark.getBookTitle());
                category.setBookDescription(bookMark.getBookDescription());
                category.setBookPublisher(bookMark.getBookPublisher());
                category.setBookUrl(bookMark.getBookUrl());
                category.setCategoryName(bookMark.getCategoryName());
                category.setCatId(bookMark.getCatId());
                category.setBookThumbnailS(bookMark.getBookThumbnailS());


                Intent intent = new Intent(context, BookDetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("data",category);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return bookMarkList.size();
    }
}
