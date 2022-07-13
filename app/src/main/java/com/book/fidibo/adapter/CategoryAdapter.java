package com.book.fidibo.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.book.fidibo.R;
import com.book.fidibo.activity.BookDetailActivity;
import com.book.fidibo.models.Category;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> implements Filterable {



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

    @Override
    public Filter getFilter() {
        return filterUSer;
    }


    private Filter filterUSer = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            String searchText = charSequence.toString().toLowerCase();
            List<Category> tempList = new ArrayList<>();

            if (searchText.length() ==0 || searchText.isEmpty()){
                tempList.addAll(categoryList);
            }else {
                for (Category item : categoryList){

                    if (item.getBookTitle().toLowerCase().contains(searchText)){
                        tempList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = tempList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            categoryList.clear();
            categoryList.addAll((Collection<? extends Category>) filterResults.values);
            notifyDataSetChanged();
        }
    };



}
