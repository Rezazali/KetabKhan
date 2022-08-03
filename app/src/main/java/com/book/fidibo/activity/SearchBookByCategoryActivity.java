package com.book.fidibo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import com.book.fidibo.R;
import com.book.fidibo.adapter.CategoryAdapter;
import com.book.fidibo.models.Category;
import com.book.fidibo.models.objectModel.CategoryModel;
import com.book.fidibo.requestBody.IResponseListener;
import com.book.fidibo.requestBody.WebServiceCaller;

import java.util.ArrayList;
import java.util.List;

public class SearchBookByCategoryActivity extends AppCompatActivity implements CategoryAdapter.UserOnClickListener {




    RecyclerView recyclerCategoryBook;
    AppCompatImageView img_back;
    AppCompatTextView txt_title;

    List<Category> category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.search_book_by_category);

        recyclerCategoryBook = findViewById(R.id.recyclerCategoryBook);
        img_back = findViewById(R.id.img_back);
        txt_title = findViewById(R.id.txt_title_toolbar);

        String title = getIntent().getStringExtra("title");

        Log.d("","");
        category = getIntent().getParcelableArrayListExtra("data");

        txt_title.setText(title);


        CategoryAdapter categoryAdapter = new CategoryAdapter(category,SearchBookByCategoryActivity.this,SearchBookByCategoryActivity.this);

        recyclerCategoryBook.setAdapter(categoryAdapter);

        LinearLayoutManager manager = new LinearLayoutManager(SearchBookByCategoryActivity.this,RecyclerView.VERTICAL,false);
        recyclerCategoryBook.setLayoutManager(manager);


        img_back.setOnClickListener(view -> onBackPressed());

    }


    @Override
    public void Category(Category category) {
        Intent intent = new Intent(this, BookDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("data",category);
        startActivity(intent);
    }
}