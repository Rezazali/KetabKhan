package com.book.fidibo.activity;


import androidx.appcompat.app.AppCompatActivity;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.Toast;


import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.ActivityBookDetailBinding;
import com.book.fidibo.models.Category;
import com.downloader.Error;
import com.downloader.OnCancelListener;
import com.downloader.OnDownloadListener;
import com.downloader.OnPauseListener;
import com.downloader.OnProgressListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.PRDownloader;
import com.downloader.Progress;
import com.squareup.picasso.Picasso;

import java.io.File;

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
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Downloading...");

        bundle = getIntent().getExtras();
        category = bundle.getParcelable("data");
        appDatabase = AppDatabase.getInstance(getApplicationContext());

        Log.d("","");

        setDataBookDetail();

        String dirPath = getFilesDir().getAbsolutePath()+File.separator+"downloads";



        binding.imgBack.setOnClickListener(view -> onBackPressed());

        binding.btnDownloadPdf.setOnClickListener(view -> {
/*
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(category.getBookUrl()));
            startActivity(intent);

            this.saveBook(category.getId());

            binding.btnDownloadPdf.setText("showPdf");*/

            downloadManager(dialog,dirPath);

            saveBook(category.getId());

        });

    }

    public void saveBook(String categoryId){

        if (appDatabase.idao().isRowIsExist(Integer.parseInt(categoryId))){

            appDatabase.idao().deleteVideo(Integer.parseInt(categoryId));
        }else {
            appDatabase.idao().insert(category);
        }
    }

    public void setDataBookDetail(){

        Spanned htmlAsSpanned = Html.fromHtml(category.getBookDescription());
        binding.txtTitle.setText(category.getBookTitle());
        binding.txtPublisher.setText(category.getBookPublisher());
        binding.txtDescription.setText(htmlAsSpanned);

        binding.ratingBar.setRating(Integer.parseInt(category.getTotalRate()));

        binding.txtCategory.setText(category.getCategoryName());
        binding.txtPublisherInfo.setText(category.getBookPublisher());
        binding.txtDownload.setText(category.getTotalDownload());
        Picasso.get().load(Uri.parse(category.getBookThumbnailS())).into(binding.imgBookDetail);
    }

    public void downloadManager(Dialog dialog,String dirPath){
        PRDownloader.download(String.valueOf(Uri.parse(category.getBookUrl())),dirPath,category.getBookTitle()+".pdf")
                .build()
                .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                    @Override
                    public void onStartOrResume() {

                    }
                })

                .setOnProgressListener(new OnProgressListener() {
                    @Override
                    public void onProgress(Progress progress) {
                        dialog.show();
                            /*long per = progress.currentBytes*100 /progress.totalBytes;
                            dialog.setMessage("downloding..."+per);*/

                    }
                })
                .start(new OnDownloadListener() {
                    @Override
                    public void onDownloadComplete() {
                        Toast.makeText(BookDetailActivity.this, "completed", Toast.LENGTH_SHORT).show();
                        Log.d("","");
                        dialog.cancel();
                    }

                    @Override
                    public void onError(Error error) {

                        Toast.makeText(BookDetailActivity.this, "fauild"+error.toString(), Toast.LENGTH_SHORT).show();
                        Log.d("","");
                    }
                });
    }
}