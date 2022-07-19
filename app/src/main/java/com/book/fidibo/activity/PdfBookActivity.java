package com.book.fidibo.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import com.book.fidibo.databinding.ActivityPdfBookBinding;


import java.io.File;


public class PdfBookActivity extends AppCompatActivity {
    ActivityPdfBookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPdfBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       // File myFile = new File(getFilesDir().toString());
        File file = new File("/storage/emulated/0/Download/34032_Ubuntu-Linux-Toolbox-1000+-Commands-for-Ubuntu-and-Debian-Power-Users-by-Christopher-Negus-(z-lib.org).pdf");

        binding.pdfView.fromFile(file).load();

    }

}