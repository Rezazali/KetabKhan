package com.book.fidibo.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.book.fidibo.R;
import com.book.fidibo.activity.BookDetailActivity;
import com.book.fidibo.activity.PdfBookActivity;
import com.book.fidibo.adapter.viewHolder.LibraryViewHolder;
import com.book.fidibo.models.Category;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryViewHolder> {



    List<Category> categoryList;
    Context context;
    CategoryAdapter.UserOnClickListener userOnClickListener;
    public LibraryAdapter(List<Category> categoryList,Context context, CategoryAdapter.UserOnClickListener userOnClickListener){
        this.categoryList = categoryList;
        this.context = context;
        this.userOnClickListener = userOnClickListener;
    }




    public interface UserOnClickListener{
        void Category(Category category);
    }


    @NonNull
    @Override
    public LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.book_library_model,null);


        return new LibraryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryViewHolder holder, int position) {



        Log.d("","");
        Category category = categoryList.get(position);

        holder.txt_bookTitle.setText(category.getBookTitle());
        holder.txt_publisher.setText(category.getBookPublisher());
        Picasso.get().load(category.getBookThumbnailS()).into(holder.img_book);

        holder.btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userOnClickListener.Category(category);
            }
        });


        holder.rel_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PdfBookActivity.class);
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
