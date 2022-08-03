package com.book.fidibo.activity.uiActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.book.fidibo.activity.BookDetailActivity;
import com.book.fidibo.adapter.SearchAdapter;
import com.book.fidibo.databinding.ActivitySearchViewBinding;
import com.book.fidibo.models.Category;
import com.book.fidibo.models.objectModel.CategoryModel;
import com.book.fidibo.requestBody.IResponseListener;
import com.book.fidibo.requestBody.WebServiceCaller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

public class SearchViewActivity extends AppCompatActivity implements SearchAdapter.UserOnClickListener {

    ActivitySearchViewBinding binding;
    WebServiceCaller webServiceCaller;
    List<Category> categoryList1 = new ArrayList<>();

    SearchAdapter searchAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding =
                ActivitySearchViewBinding.
                        inflate(getLayoutInflater());

        setContentView(
                binding.
                        getRoot());

        webServiceCaller =
                new WebServiceCaller();

        binding.searchToolbar.getChildAt(0).setOnClickListener(view -> onBackPressed());

    /*    binding.searchView.clearFocus();
        binding.searchView.setActivated(true);
        binding.searchView.setIconified(false);
        binding.s.setIconified(false);*/



        webServiceCaller.getSearchBook(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                CategoryModel model = (CategoryModel) ResponseMessage;
                categoryList1 = model.getCategoryList();

                 searchAdapter =
                         new SearchAdapter(
                                 categoryList1,
                                 getApplicationContext(),
                                 SearchViewActivity.this);

                binding.recyclerSearch.setAdapter(searchAdapter);


                LinearLayoutManager manager =
                        new LinearLayoutManager(
                                getApplicationContext(),
                                RecyclerView.VERTICAL,
                                false);

                binding.
                        recyclerSearch.
                        setLayoutManager(manager);

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });

        binding.edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
                searchAdapter.notifyDataSetChanged();
            }
        });

    }

    public void filter(String text){
        List<Category> categoryList = new ArrayList<>();
        for (Category item : categoryList1){
            if (item.getBookTitle().toLowerCase().contains(text.toLowerCase())){
                categoryList.add(item);
            }
        }
        searchAdapter.filterList(categoryList);
    }


    @Override
    public void onClick(Category category) {
        Intent intent = new Intent(SearchViewActivity.this, BookDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("data",category);
        startActivity(intent);
    }
}


