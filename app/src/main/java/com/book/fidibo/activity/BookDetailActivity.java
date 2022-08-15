package com.book.fidibo.activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.annotation.SuppressLint;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.book.fidibo.R;
import com.book.fidibo.adapter.CategoryAdapter;
import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.ActivityBookDetailBinding;
import com.book.fidibo.models.BookMark;
import com.book.fidibo.models.Category;
import com.book.fidibo.models.objectModel.CategoryModel;
import com.book.fidibo.requestBody.IResponseListener;
import com.book.fidibo.requestBody.WebServiceCaller;
import com.downloader.Error;
import com.downloader.OnDownloadListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.PRDownloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookDetailActivity extends AppCompatActivity implements CategoryAdapter.UserOnClickListener {


    AppDatabase appDatabase;
    ActivityBookDetailBinding binding;

    Bundle bundle;

    Category category;


    WebServiceCaller webServiceCaller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookDetailBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        appDatabase = AppDatabase.getInstance(getApplicationContext());


        binding.viewGradiant.bringToFront();

        setSupportActionBar(binding.toolbar);
        bundle = getIntent().getExtras();

        //create tow methode and filter tow class for show in the onCreate
        ProgressDialog dialog = new ProgressDialog(this);




        Log.d("","");
        category = bundle.getParcelable("data");

        setDataBookDetail();
        Log.d("","");
        binding.txtTitleToolbar.setText(category.getBookTitle());
        binding.txtTitle.setText(category.getBookTitle());

        BookMark bookMark =
                new BookMark(category.getId(),category.getCatId(),category.getBookTitle(),category.getBookUrl(),category.getBookThumbnailS(),category.getBookPublisher(),category.getCategoryName(), category.getBookDescription());






        if (appDatabase.idao().isRowIsExistBookMArk(Integer.parseInt(category.getId()))){

            binding.imgBookMark.setImageResource(R.drawable.ic_book_mark_black);

        }else {

            binding.imgBookMark.setImageResource(R.drawable.ic_book_mark_whit);
        }

        binding.imgBookMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("","");
                if (appDatabase.idao().isRowIsExistBookMArk(Integer.parseInt(category.getId()))){

                   binding.imgBookMark.setImageResource(R.drawable.ic_book_mark_whit);

                   appDatabase.idao().deleteBookMArk(Integer.parseInt(category.getId()));

               }else {
                   binding.imgBookMark.setImageResource(R.drawable.ic_book_mark_black);

                   long result = appDatabase.idao().insertBookMArk(bookMark);

                   if (result >0){
                       Toast.makeText(BookDetailActivity.this, "yes", Toast.LENGTH_SHORT).show();
                   }else{
                       Toast.makeText(BookDetailActivity.this, "no", Toast.LENGTH_SHORT).show();
                   }
               }
            }
        });

        webServiceCaller = new WebServiceCaller();

        webServiceCaller.getListBook(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                Log.d("","");

                CategoryModel model = (CategoryModel) ResponseMessage;
                List<Category>categoryList = model.getCategoryList();

                CategoryAdapter adapter =
                        new CategoryAdapter(
                                categoryList,
                                getApplicationContext()
                                ,BookDetailActivity.this);

                binding.recyclerRecent.setAdapter(adapter);


                LinearLayoutManager manager =
                        new LinearLayoutManager(
                                getApplicationContext(),
                                LinearLayoutManager.HORIZONTAL,
                                false);

                binding.recyclerRecent.setLayoutManager(manager);



            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });



        @SuppressLint("SdCardPath")
        String dirPath = "/data/data/com.book.fidibo/files/downloads";




        binding.imgBack.setOnClickListener(view -> onBackPressed());

        binding.btnDownloadPdf.setOnClickListener(view -> {

            if (appDatabase.idao().isRowIsExist(Integer.parseInt(category.getId()))){


                Intent intent = new Intent(BookDetailActivity.this,PdfBookActivity.class);
                intent.putExtra("data",category);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }else {

                downloadManager(dialog,dirPath);
                appDatabase.idao().insert(category);
            }


        });


    }


    @Override
    protected void onResume() {
        super.onResume();
        if (appDatabase.idao().isRowIsExist(Integer.parseInt(category.getId()))){

            binding.btnDownloadPdf.setText("خواندن");
        }else{

            binding.btnDownloadPdf.setText("دانلود");
        }
    }

    public void saveBook(String categoryId){

        if (appDatabase.idao().isRowIsExist(Integer.parseInt(categoryId))){

            appDatabase.idao().deleteVideo(Integer.parseInt(categoryId));
        }else {
            appDatabase.idao().insert(category);
        }
    }


    public void setDataBookDetail(){

        Log.d("","");
        Spanned htmlAsSpanned = Html.fromHtml(category.getBookDescription());
        binding.txtTitle.setText(category.getBookTitle());
        binding.txtPublisher.setText(category.getBookPublisher());
        binding.txtDescription.setText(htmlAsSpanned);
        binding.txtDescription.setTrimCollapsedText("باز");
        binding.txtDescription.setTrimExpandedText("بسته");


        Log.d("","");
        binding.txtCategory.setText(category.getCategoryName());
        binding.txtPublisherInfo.setText(category.getBookPublisher());
        binding.txtDownload.setText(category.getTotalDownload());
        Picasso.get().load(Uri.parse(category.getBookThumbnailS())).into(binding.imgBookDetail);




       /* SpannableString ss = new SpannableString(htmlAsSpanned);

        ClickableSpan span1 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {

            }
        };

        ClickableSpan span2 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {

            }
        };

        ss.setSpan(span1, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span2, 6, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        binding.txtDescription.setText(ss);
        binding.txtDescription.setMovementMethod(LinkMovementMethod.getInstance());*/
    }


    public void downloadManager(ProgressDialog dialog,String dirPath){
        PRDownloader.download(
                String.valueOf(Uri.parse(category.getBookUrl())),
                        dirPath,
                        category.getBookTitle()+".pdf")
                .build()
                .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                    @Override
                    public void onStartOrResume() {

                    }
                })

                .setOnProgressListener(progress -> {
                    dialog.show();
                        long per = progress.currentBytes*100 /progress.totalBytes;
                        dialog.setMessage(  "درحال دانلود لطفا منتظر بمانید..." +per+"درصد");

                })
                .start(new OnDownloadListener() {
                    @Override
                    public void onDownloadComplete() {
                        Toast.makeText(BookDetailActivity.this, "با موفقیت دانلود شد", Toast.LENGTH_SHORT).show();
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


    @Override
    public void Category(Category category) {

        Intent intent = new Intent(getApplicationContext(), BookDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("data",category);
        startActivity(intent);
    }
}