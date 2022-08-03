package com.book.fidibo.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.book.fidibo.R;
import com.book.fidibo.adapter.viewHolder.HomeViewHolder;
import com.book.fidibo.models.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {



    List<Category> categoryList;
    Context context;
    HomeAdapter.UserOnClickListener onClickListener;
    public HomeAdapter(List<Category> categoryList, Context context, HomeAdapter.UserOnClickListener onClickListener){
        this.categoryList = categoryList;
        this.onClickListener = onClickListener;
        this.context = context;
    }

    public interface UserOnClickListener{
        void onClick(Category category);
    }


    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.book_row, null);
        return new HomeViewHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {


        Category category = categoryList.get(position);

            Picasso.get()
                    .load(Uri.parse(category.getBookThumbnailS()))
                    .placeholder(R.raw.loading_dots)
                    .placeholder(R.color.gray)
                    .into(holder.img_book);
            holder.lottie.playAnimation();
            holder.lottie.setVisibility(View.GONE);

            /*holder.getLottie().setVisibility(View.INVISIBLE);*/



        Log.d("","");
        holder.img_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,view,"myImage");*/
                onClickListener.onClick(category);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


















   /*
    Category category;
    List<Category>categoryList;
    Context context;
    UserOnClickListener userOnClickListener;
    public HomeAdapter(List<Category>categoryList,Context context){
        this.categoryList = categoryList;
        this.context = context;
    }

    public interface UserOnClickListener{
        void OnClickListener(Category category);
    }



    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.book_library_model,null);

        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {

        Log.d("","");
        category= categoryList.get(position);
        holder.txt_bookTitle.setText(category.getBookTitle());
        holder.txt_publisher.setText(category.getBookPublisher());
        *//*Picasso.get().load(category.getBookThumbnailS()).into(holder.img_book_bottom);*//*
        Picasso.get().load(category.getBookThumbnailS()).into(holder.img_book_library);

        holder.btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              *//*  Intent intent = new Intent(context, BottomSheet.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("data",category);
                context.startActivity(intent);*//*

            }
        });
        holder.rel_book_library.setOnClickListener(new View.OnClickListener() {
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
    }*/
}
