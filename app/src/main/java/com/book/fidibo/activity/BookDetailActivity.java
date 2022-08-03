package com.book.fidibo.activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.Toast;


import com.book.fidibo.adapter.BookByCategoryAdapter;
import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.ActivityBookDetailBinding;
import com.book.fidibo.models.Book;
import com.book.fidibo.models.Category;
import com.book.fidibo.models.objectModel.BookModel;
import com.book.fidibo.requestBody.IResponseListener;
import com.book.fidibo.requestBody.WebServiceCaller;
import com.downloader.Error;
import com.downloader.OnDownloadListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.PRDownloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookDetailActivity extends AppCompatActivity implements BookByCategoryAdapter.UserOnClickListener {


    AppDatabase appDatabase;
    ActivityBookDetailBinding binding;

    Bundle bundle;

    Category category;

    Book book;


    WebServiceCaller webServiceCaller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        //create tow methode and filter tow class for show in the onCreate
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Downloading...");

        bundle = getIntent().getExtras();
        category = bundle.getParcelable("data");

        Log.d("","");

        book = bundle.getParcelable("dataa");

      /*  categoryList = getIntent().getParcelableArrayListExtra("dataa");
        if(categoryList==null) categoryList = getIntent().getParcelableExtra("dataa");*/



        webServiceCaller = new WebServiceCaller();

        webServiceCaller.getListBook(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                Log.d("","");
                BookModel model = (BookModel) ResponseMessage;
                List<Book>bookList = model.getONLINEBook();

                BookByCategoryAdapter adapter = new BookByCategoryAdapter(bookList,getApplicationContext(),BookDetailActivity.this::onClick);
                binding.recyclerRecent.setAdapter(adapter);

                LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
                binding.recyclerRecent.setLayoutManager(manager);



            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });

        if (category != null){
            setDataBookDetail();
            binding.txtTitleToolbar.setText(category.getBookTitle());
            binding.txtTitle.setText(category.getBookTitle());
        }else{

            binding.txtPublisher.setText(book.getBookPublisher());
            Spanned htmlAsSpanned = Html.fromHtml(book.getBookDescription());
            binding.txtDescription.setText(htmlAsSpanned);

            binding.txtCategory.setText(book.getCategoryName());
            binding.txtPublisherInfo.setText(book.getBookPublisher());
            binding.txtDownload.setText(book.getTotalDownload());
            Picasso.get().load(Uri.parse(book.getBookThumbnailS())).into(binding.imgBookDetail);

        }




        appDatabase = AppDatabase.getInstance(getApplicationContext());

        Log.d("","");


        @SuppressLint("SdCardPath")
        String dirPath = "/data/data/com.book.fidibo/files/downloads";



        binding.imgBack.setOnClickListener(view -> onBackPressed());

        binding.btnDownloadPdf.setOnClickListener(view -> {

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

                .setOnProgressListener(progress -> {
                    dialog.show();
                        /*long per = progress.currentBytes*100 /progress.totalBytes;
                        dialog.setMessage("downloding..."+per);*/

                })
                .start(new OnDownloadListener() {
                    @Override
                    public void onDownloadComplete() {
                        Toast.makeText(BookDetailActivity.this, "completed", Toast.LENGTH_SHORT).show();
                        Log.d("","");
                        dialog.cancel();

                        Intent intent = new Intent(BookDetailActivity.this,PdfBookActivity.class);
                        intent.putExtra("data",category);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }

                    @Override
                    public void onError(Error error) {

                        Toast.makeText(BookDetailActivity.this, "fauild"+error.toString(), Toast.LENGTH_SHORT).show();
                        Log.d("","");
                    }
                });
    }



    public void setrecy(){



    }

    @Override
    public void onClick(Book book) {
        Log.d("","");
        Intent intent = new Intent(getApplicationContext(), BookDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("dataa",book);
        startActivity(intent);
    }
}