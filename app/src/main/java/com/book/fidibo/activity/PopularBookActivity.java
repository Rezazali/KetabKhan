package com.book.fidibo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.book.fidibo.adapter.CategoryAdapter;
import com.book.fidibo.adapter.HomeAdapter;
import com.book.fidibo.databinding.ActivityPopularBookBinding;
import com.book.fidibo.models.Category;

import java.util.List;

public class PopularBookActivity extends AppCompatActivity implements CategoryAdapter.UserOnClickListener {

    ActivityPopularBookBinding binding;
    List<Category>categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPopularBookBinding.inflate(getLayoutInflater());

        Log.d("","");
        categories = getIntent().getParcelableArrayListExtra("data");

        String title = getIntent().getStringExtra("title");
        binding.txtTitleToolbar.setText(title);

        binding.imgBack.setOnClickListener(view -> onBackPressed());


        HomeAdapter adapter = new HomeAdapter(categories,getApplicationContext(),this::Category);
        binding.recyclerMore.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
        binding.recyclerMore.setLayoutManager(manager);

        Log.d("","");


        CategoryAdapter categoryAdapter = new CategoryAdapter(categories,getApplicationContext(),
                this);
        binding.recyclerAllBook.setAdapter(categoryAdapter);

        LinearLayoutManager manager1 = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false);
        binding.recyclerAllBook.setLayoutManager(manager1);



        setContentView(binding.getRoot());


    }

    @Override
    public void Category(Category category) {
        Intent intent = new Intent(this, BookDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("data",category);
        startActivity(intent);
    }
}