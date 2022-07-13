package com.book.fidibo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.book.fidibo.MainActivity;
import com.book.fidibo.R;
import com.book.fidibo.adapter.CategoryAdapter;
import com.book.fidibo.databinding.ActivityCategoryBookBinding;
import com.book.fidibo.models.Category;
import com.book.fidibo.models.CategoryModel;
import com.book.fidibo.ui.IResponseListener;
import com.book.fidibo.ui.WebServiceCaller;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SearchBookByCategoryActivity extends AppCompatActivity implements CategoryAdapter.UserOnClickListener {


    ActivityCategoryBookBinding binding;

    WebServiceCaller webServiceCaller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        getCategoryPrograming();

        getCategoryGrowUp();

        getCategoryPsychology();



    }

    public void getCategoryPrograming(){
        webServiceCaller = new WebServiceCaller();
        webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {


                CategoryModel model = (CategoryModel) ResponseMessage;
                List<Category> categoryList = model.getCategoryList();
                CategoryAdapter adapter = new CategoryAdapter(categoryList,getApplicationContext(),
                        SearchBookByCategoryActivity.this);

                binding.recyclerCategoryBook.setAdapter(adapter);

                LinearLayoutManager manager =
                        new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                binding.recyclerCategoryBook.setLayoutManager(manager);

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },2);
    }

    public void getCategoryGrowUp(){
        webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {
                CategoryModel model = (CategoryModel) ResponseMessage;
                List<Category> categoryList = model.getCategoryList();
                CategoryAdapter adapter = new CategoryAdapter(categoryList,getApplicationContext(),
                        SearchBookByCategoryActivity.this);

                binding.recyclerCategoryBook.setAdapter(adapter);

                LinearLayoutManager manager =
                        new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                binding.recyclerCategoryBook.setLayoutManager(manager);

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },3);
    }

    public void getCategoryPsychology(){
        webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {
                CategoryModel model = (CategoryModel) ResponseMessage;
                List<Category> categoryList = model.getCategoryList();
                CategoryAdapter adapter = new CategoryAdapter(categoryList,getApplicationContext(),
                        SearchBookByCategoryActivity.this);

                binding.recyclerCategoryBook.setAdapter(adapter);

                LinearLayoutManager manager =
                        new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                binding.recyclerCategoryBook.setLayoutManager(manager);

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },4);

    }

    @Override
    public void Category(Category category) {
        Intent intent = new Intent(this, BookDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("data",category);
       startActivity(intent);
    }
}