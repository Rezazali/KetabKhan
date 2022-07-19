package com.book.fidibo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.book.fidibo.R;
import com.book.fidibo.adapter.CategoryAdapter;
import com.book.fidibo.models.Category;
import com.book.fidibo.models.objectModel.CategoryModel;
import com.book.fidibo.requestBody.IResponseListener;
import com.book.fidibo.requestBody.WebServiceCaller;

import java.util.List;

public class SearchBookByCategoryActivity extends AppCompatActivity implements CategoryAdapter.UserOnClickListener {



    RecyclerView recyclerCategoryBook;
    WebServiceCaller webServiceCaller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.search_book_by_category);

        recyclerCategoryBook = findViewById(R.id.recyclerCategoryBook);


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

                recyclerCategoryBook.setAdapter(adapter);

                LinearLayoutManager manager =
                        new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                recyclerCategoryBook.setLayoutManager(manager);

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

                recyclerCategoryBook.setAdapter(adapter);

                LinearLayoutManager manager =
                        new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                recyclerCategoryBook.setLayoutManager(manager);

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

                recyclerCategoryBook.setAdapter(adapter);

                LinearLayoutManager manager =
                        new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                recyclerCategoryBook.setLayoutManager(manager);

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