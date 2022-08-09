package com.book.fidibo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.book.fidibo.R;
import com.book.fidibo.adapter.viewHolder.SpecialChooseViewHolder;
import com.book.fidibo.models.SpecialCategory;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SpecialChooseAdapter extends RecyclerView.Adapter<SpecialChooseViewHolder> {


    List<SpecialCategory> specialCategories;
    Context context;
    public SpecialChooseAdapter(List<SpecialCategory> specialCategories,Context context){
        this.specialCategories = specialCategories;
        this.context = context;
    }


    @NonNull
    @Override
    public SpecialChooseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.book_row,null);
        return new SpecialChooseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialChooseViewHolder holder, int position) {

        SpecialCategory category = specialCategories.get(position);
        Picasso.get().load(category.getBookThumbnailS()).into(holder.img_book);


    }

    @Override
    public int getItemCount() {
        return specialCategories.size();
    }
}
