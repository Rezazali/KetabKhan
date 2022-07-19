package com.book.fidibo.adapter;

import android.annotation.SuppressLint;
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
import com.book.fidibo.adapter.viewHolder.SearchViewHolder;
import com.book.fidibo.models.Category;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> implements Filterable {

    List<Category> searchList;
    Context context;
    UserOnClickListener listener;
    public SearchAdapter (List<Category> searchList,Context context,UserOnClickListener listener){
        this.searchList = searchList;
        this.context = context;
        this.listener = listener;
    }

    public  interface UserOnClickListener{
        void onClick(Category category);
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.search_model,null);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {

        Log.d("","");
        Category category = searchList.get(position);
        holder.txt_title.setText(category.getBookTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(category);
            }
        });

    }

    @Override
    public int getItemCount() {
        return searchList.size();
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
                tempList.addAll(searchList);
            }else {
                for (Category item : searchList){

                    if (item.getBookTitle().toLowerCase().contains(searchText)){
                        tempList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = tempList;

            return results;
        }

        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            searchList.clear();
            searchList.addAll((Collection<? extends Category>) filterResults.values);
            notifyDataSetChanged();

        }
    };

}
