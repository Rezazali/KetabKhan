package com.book.fidibo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.book.fidibo.R;
import com.book.fidibo.adapter.BookMarkAdapter;
import com.book.fidibo.adapter.LibraryAdapter;
import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.ActivityBookMarkBinding;

public class BookMarkActivity extends AppCompatActivity {


    ActivityBookMarkBinding binding;
    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookMarkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        appDatabase = AppDatabase.getInstance(BookMarkActivity.this);


        BookMarkAdapter adapter = new BookMarkAdapter(appDatabase.idao().bookMarkList(),getApplicationContext());
        binding.recyclerBookMark.setAdapter(adapter);


        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        binding.recyclerBookMark.setLayoutManager(manager);

    }
}