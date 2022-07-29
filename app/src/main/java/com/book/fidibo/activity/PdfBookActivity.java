package com.book.fidibo.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;

import com.book.fidibo.databinding.ActivityPdfBookBinding;
import com.book.fidibo.models.Category;


import java.io.File;


public class PdfBookActivity extends AppCompatActivity {
    ActivityPdfBookBinding binding;
    Bundle bundle;
    Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPdfBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        bundle = getIntent().getExtras();
        category = bundle.getParcelable("data");


        @SuppressLint("SdCardPath")
        File file = new File("/data/data/com.book.fidibo/files/downloads/"+category.getBookTitle()+".pdf");


        binding.pdfView.fromFile(file).load();

    }

}