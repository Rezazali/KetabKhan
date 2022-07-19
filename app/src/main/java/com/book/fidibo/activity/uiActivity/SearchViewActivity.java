package com.book.fidibo.activity.uiActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.book.fidibo.activity.BookDetailActivity;
import com.book.fidibo.adapter.SearchAdapter;
import com.book.fidibo.databinding.ActivitySearchViewBinding;
import com.book.fidibo.models.Category;
import com.book.fidibo.models.objectModel.CategoryModel;
import com.book.fidibo.requestBody.IResponseListener;
import com.book.fidibo.requestBody.WebServiceCaller;

import java.util.List;

public class SearchViewActivity extends AppCompatActivity implements SearchAdapter.UserOnClickListener {

    ActivitySearchViewBinding binding;
    WebServiceCaller webServiceCaller;


    SearchAdapter searchAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        webServiceCaller = new WebServiceCaller();
        binding.searchView.clearFocus();
        binding.searchView.setActivated(true);
        binding.searchView.setIconified(false);
        binding.searchView.setIconified(false);




        webServiceCaller.getSearchBook(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                CategoryModel model = (CategoryModel) ResponseMessage;
                List<Category> categoryList = model.getCategoryList();
                 searchAdapter =
                         new SearchAdapter(categoryList,getApplicationContext(), SearchViewActivity.this);
                binding.recyclerSearch.setAdapter(searchAdapter);


                LinearLayoutManager manager =
                        new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false);
                binding.recyclerSearch.setLayoutManager(manager);

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchAdapter.getFilter().filter(newText);

                return false;
            }
        });


    }


    @Override
    public void onClick(Category category) {
        Intent intent = new Intent(SearchViewActivity.this, BookDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("data",category);
        startActivity(intent);
    }
}


