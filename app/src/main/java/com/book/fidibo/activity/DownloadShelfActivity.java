package com.book.fidibo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.book.fidibo.R;
import com.book.fidibo.adapter.LibraryAdapter;
import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.ActivityDownloadShelfBinding;
import com.book.fidibo.models.Category;

public class DownloadShelfActivity extends AppCompatActivity implements LibraryAdapter.UserOnClickListener {

    ActivityDownloadShelfBinding binding;
    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDownloadShelfBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        appDatabase = AppDatabase.getInstance(getApplicationContext());

        String title = getIntent().getStringExtra("title");

        binding.imgBack.setOnClickListener(view -> finish());
        binding.txtTitleToolbar.setText(title);

        LibraryAdapter adapter = new LibraryAdapter(appDatabase.idao().categoryList(),getApplicationContext(),this::Category);
        binding.recyclerDownloadShelf.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        binding.recyclerDownloadShelf.setLayoutManager(manager);


    }

    @Override
    public void Category(Category category) {

    }
}