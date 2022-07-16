package com.book.fidibo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;

import com.book.fidibo.R;
import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.ActivityBookDetailBinding;
import com.book.fidibo.models.Category;
import com.squareup.picasso.Picasso;

public class BookDetailActivity extends AppCompatActivity {


    AppDatabase appDatabase;
    ActivityBookDetailBinding binding;
    Bundle bundle;
    Category category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //create tow methode and filter tow class for show in the onCreate

        bundle = getIntent().getExtras();
        category = bundle.getParcelable("data");
        appDatabase = AppDatabase.getInstance(getApplicationContext());

        setDataBookDetail();

        binding.imgBack.setOnClickListener(view -> onBackPressed());

        binding.btnDownloadPdf.setOnClickListener(view -> {

            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(category.getBookUrl()));
            startActivity(intent);

            binding.btnDownloadPdf.setText("showPdf");

            if (appDatabase.idao().isRowIsExist(Integer.parseInt(category.getId()))){

                appDatabase.idao().deleteVideo(Integer.parseInt(category.getId()));
            }else {
                appDatabase.idao().insert(category);
            }
        });

    }


    public void setDataBookDetail(){

        Spanned htmlAsSpanned = Html.fromHtml(category.getBookDescription());
        binding.txtTitle.setText(category.getBookTitle());
        binding.txtPublisher.setText(category.getBookPublisher());
        binding.txtDescription.setText(htmlAsSpanned);

        AppCompatRatingBar ratingBar = new AppCompatRatingBar(getApplicationContext(),
                null, Integer.parseInt(category.getTotalRate()));

        binding.txtCategory.setText(category.getCategoryName());
        binding.txtPublisherInfo.setText(category.getBookPublisher());
        binding.txtDownload.setText(category.getTotalDownload());
        Picasso.get().load(Uri.parse(category.getBookThumbnailS())).into(binding.imgBookDetail);
    }
}