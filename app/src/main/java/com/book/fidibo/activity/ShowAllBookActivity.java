package com.book.fidibo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.book.fidibo.adapter.ShowAllBookAdapter;
import com.book.fidibo.databinding.ActivityShowAllBookBinding;
import com.book.fidibo.models.Category;

import java.util.List;

public class ShowAllBookActivity extends AppCompatActivity {

    ActivityShowAllBookBinding binding;
    List<Category> categories;

    List<Category> category;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowAllBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bundle = getIntent().getExtras();
        category = bundle.getParcelable("data");

        String title = getIntent().getStringExtra("title");

        categories = getIntent().getParcelableArrayListExtra("data");

        binding.txtTitleToolbar.setText(title);

        binding.imgBack.setOnClickListener(view -> onBackPressed());

        ShowAllBookAdapter adapter = new ShowAllBookAdapter(categories,ShowAllBookActivity.this);
        binding.recyclerShowAllBook.setAdapter(adapter);


        LinearLayoutManager manager = new LinearLayoutManager(ShowAllBookActivity.this, RecyclerView.VERTICAL,false);
        binding.recyclerShowAllBook.setLayoutManager(manager);


    }
}