package com.book.fidibo.fragment;


import android.annotation.SuppressLint;

import android.content.Intent;


import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


import com.book.fidibo.R;
import com.book.fidibo.activity.BookDetailActivity;
import com.book.fidibo.activity.PdfBookActivity;
import com.book.fidibo.activity.PopularBookActivity;

import com.book.fidibo.activity.SearchBookByCategoryActivity;
import com.book.fidibo.activity.ShowAllBookActivity;
import com.book.fidibo.adapter.CategoryScrollAdapter;
import com.book.fidibo.adapter.HomeAdapter;
import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.FragmentHomeBinding;

import com.book.fidibo.models.Category;
import com.book.fidibo.models.CategoryScroll;
import com.book.fidibo.models.objectModel.CategoryModel;
import com.book.fidibo.models.objectModel.CategoryScrollModel;
import com.book.fidibo.requestBody.IResponseListener;
import com.book.fidibo.requestBody.WebServiceCaller;
import com.book.fidibo.ui.DarkTheme;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;


public class HomeFragment extends Fragment implements HomeAdapter.UserOnClickListener {

    FragmentHomeBinding binding;
    WebServiceCaller webServiceCaller;
    AppDatabase appDatabase;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        webServiceCaller = new WebServiceCaller();



        appDatabase = AppDatabase.getInstance(getActivity());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Configuration configuration = getResources().getConfiguration();
            configuration.setLayoutDirection(new Locale("ltr"));
            getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        }


/*
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
*/
        binding.setVisibility.setVisibility(View.GONE);

        getCategoryScroll();
        getCategoryPrograming();
        getCategoryGrowUp();
        getCategoryPsychology();
        getCategoryNovel();
        getCategoryNegotiation();









        binding.imgPublisher.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {
                CategoryModel model = (CategoryModel) ResponseMessage;
                ArrayList<Category>categoryList = (ArrayList<Category>) model.getCategoryList();
                String title = "انتشارات آکسفورد";
                Intent intent = new Intent(getActivity(), SearchBookByCategoryActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putParcelableArrayListExtra("data", (ArrayList<? extends Parcelable>) categoryList);
                intent.putExtra("title",title);
                startActivity(intent);
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },7));

        binding.imgPublisher2.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {
                CategoryModel model = (CategoryModel) ResponseMessage;
                ArrayList<Category>categoryList = (ArrayList<Category>) model.getCategoryList();
                String title = "انتشارات کیان";
                Intent intent = new Intent(getActivity(), SearchBookByCategoryActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putParcelableArrayListExtra("data", (ArrayList<? extends Parcelable>) categoryList);
                intent.putExtra("title",title);
                startActivity(intent);
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },2));










        binding.cardGorw.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                CategoryModel categoryModel = (CategoryModel) ResponseMessage;
                ArrayList<Category>categoryList = (ArrayList<Category>) categoryModel.getCategoryList();

                String title = "توسعه فردی";


                setIntentPopular(categoryList,title);

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },3));


        binding.cardNovel.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                CategoryModel categoryModel = (CategoryModel) ResponseMessage;
                ArrayList<Category>categoryList = (ArrayList<Category>) categoryModel.getCategoryList();

                String title = "رمان";


                setIntentPopular(categoryList,title);


            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },5));


        binding.cardPrograming.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                CategoryModel categoryModel = (CategoryModel) ResponseMessage;
                ArrayList<Category>categoryList = (ArrayList<Category>) categoryModel.getCategoryList();

                String title = "برنامه نویسی";


                setIntentPopular(categoryList,title);


            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },2));


        binding.cardNagotiation.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                CategoryModel categoryModel = (CategoryModel) ResponseMessage;
                ArrayList<Category>categoryList = (ArrayList<Category>) categoryModel.getCategoryList();

                String title = "مذاکره";


               setIntentPopular(categoryList,title);


            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },6));


        setToolbar(binding.toolbar);







        requireActivity().getWindow().setAllowEnterTransitionOverlap(false);





        binding.tabLayout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                binding.tabLayout.setSelectedTabIndicatorColor(R.color.whiteDriver);
            }
        });


        Objects.requireNonNull(binding.tabLayout.getTabAt(1)).select();

        binding.refreshLayout.setOnRefreshListener(() -> {

                getActivity().finish();
                getActivity().overridePendingTransition(0, 0);
                getActivity().startActivity(getActivity().getIntent());
                getActivity().overridePendingTransition(0, 0);

            binding.refreshLayout.setRefreshing(false);
        });



        DarkTheme darkTheme = new DarkTheme();
        darkTheme.darkNight(requireActivity(),binding.switchColor);

        return binding.getRoot();
    }



    public void getCategoryPrograming(){



        webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {
                binding.setVisibility.setVisibility(View.VISIBLE);

                ///cleanUp with interface
                Log.d("","");
                CategoryModel model = (CategoryModel) ResponseMessage;
                List<Category> categoryList = model.getCategoryList();

                HomeAdapter adapter = new HomeAdapter(categoryList,getActivity(),HomeFragment.this::onClick);

                binding.recyclerPrograming.setAdapter(adapter);

                LinearLayoutManager manager =
                        new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
                binding.recyclerPrograming.setLayoutManager(manager);

                binding.constrainPrograming.setOnClickListener(view -> {

                    String title = "برنامه نویسی";
                    setIntentShowMore((ArrayList<Category>) categoryList,title);
                });


                Log.d("","");
            }

            @Override
            public void onFailure(String errorResponseMessage) {
                /*binding.setVisibility.setVisibility(View.GONE);*/
                Snackbar snackbar = Snackbar.make(requireView(),"اینترنت خود را چک نمایید",Snackbar.LENGTH_LONG);
                snackbar.show();
                binding.setVisibility.setVisibility(View.GONE);

            }
        },2);

    }



    public void getCategoryGrowUp(){

        webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {
                ///cleanUp with interface



                CategoryModel model = (CategoryModel) ResponseMessage;
                List<Category> categoryList = model.getCategoryList();


                HomeAdapter adapter = new HomeAdapter(categoryList,getActivity(),HomeFragment.this::onClick);



                binding.recyclerGrowUp.setAdapter(adapter);

                LinearLayoutManager manager =
                        new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
                binding.recyclerGrowUp.setLayoutManager(manager);

                binding.constrainGrowUp.setOnClickListener(view -> {
                    String title = "توسعه فردی";
                    setIntentShowMore((ArrayList<Category>) categoryList,title);
                });

            }

            @Override
            public void onFailure(String errorResponseMessage) {
            }
        },3);

    }


    public void  getCategoryPsychology(){
        webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                binding.setVisibility.setVisibility(View.VISIBLE);


                ///cleanUp with interface
                CategoryModel model = (CategoryModel) ResponseMessage;
                List<Category> categoryList = model.getCategoryList();


                HomeAdapter adapter = new HomeAdapter(categoryList,getActivity(),HomeFragment.this::onClick);

                binding.recyclerPsychology.setAdapter(adapter);

                LinearLayoutManager manager =
                        new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
                binding.recyclerPsychology.setLayoutManager(manager);

                binding.constrainPsychology.setOnClickListener(view -> {
                    String title = "روانشناسی";
                    setIntentShowMore((ArrayList<Category>) categoryList,title);
                });
            }

            @Override
            public void onFailure(String errorResponseMessage) {
               /* isConnected(false);*/
                Snackbar snackbar = Snackbar.make(requireView(),"connect internet plase",Snackbar.LENGTH_LONG);
                snackbar.show();


            }
        },4);
    }


    public void  getCategoryNovel(){
        webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                binding.txtPsychology.setVisibility(View.VISIBLE);


                ///cleanUp with interface
                CategoryModel model = (CategoryModel) ResponseMessage;
                List<Category> categoryList = model.getCategoryList();


                HomeAdapter adapter = new HomeAdapter(categoryList,getActivity(),HomeFragment.this::onClick);

                binding.recyclerNovel.setAdapter(adapter);

                LinearLayoutManager manager =
                        new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
                binding.recyclerNovel.setLayoutManager(manager);

                binding.constrainNovel.setOnClickListener(view -> {
                    String title = "رمان";
                    setIntentShowMore((ArrayList<Category>) categoryList,title);
                });
            }

            @Override
            public void onFailure(String errorResponseMessage) {
                /* isConnected(false);*/



            }
        },5);
    }


    public void  getCategoryNegotiation(){
        webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                binding.txtPsychology.setVisibility(View.VISIBLE);


                ///cleanUp with interface
                CategoryModel model = (CategoryModel) ResponseMessage;
                List<Category> categoryList = model.getCategoryList();


                HomeAdapter adapter = new HomeAdapter(categoryList,getActivity(),HomeFragment.this::onClick);

                binding.recyclerNegotiation.setAdapter(adapter);

                LinearLayoutManager manager =
                        new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
                binding.recyclerNegotiation.setLayoutManager(manager);

                binding.constrainNegotiation.setOnClickListener(view -> {
                    String title = "مذاکره";
                    setIntentShowMore((ArrayList<Category>) categoryList,title);
                });
            }

            @Override
            public void onFailure(String errorResponseMessage) {
                /* isConnected(false);*/
                Snackbar snackbar = Snackbar.make(requireView(),"connect internet plase",Snackbar.LENGTH_LONG);
                snackbar.show();


            }
        },6);
    }

    public  void  getCategoryScroll(){
        webServiceCaller.getCategoryScroll(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                CategoryScrollModel model = (CategoryScrollModel) ResponseMessage;
                List<CategoryScroll>categoryScrolls = model.getScrollList();

                CategoryScrollAdapter adapter = new CategoryScrollAdapter(categoryScrolls,getActivity());
                binding.recyclerScroll.setAdapter(adapter);


                LinearLayoutManager manager =
                        new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
                binding.recyclerScroll.setLayoutManager(manager);



            }

            @Override
            public void onFailure(String errorResponseMessage) {
                Log.d("errorResponseMessage",""+errorResponseMessage);
            }
        });

    }



    public void setToolbar(Toolbar toolbar){
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        this.enableToolbar(false);
    }

    public void enableToolbar(boolean isValid){
        Objects.requireNonNull(((AppCompatActivity) requireActivity())
                        .getSupportActionBar())
                .setDisplayShowTitleEnabled(isValid);
    }

/*
    public boolean isConnected(boolean isValid){

        ConnectivityManager manager = (ConnectivityManager) requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiNetwork = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileNetwork = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if (wifiNetwork !=null && wifiNetwork.isConnected() || mobileNetwork !=null && mobileNetwork.isConnected()){
            return true;
        }else {
            return isValid;
        }
    }*/




    @Override
    public void onClick(Category category) {
        Intent intent = new Intent(getActivity(), BookDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("data",category);
        startActivity(intent);
    }

    public void setIntentShowMore(ArrayList<Category>categoryList,String title){
        Intent intent = new Intent(getActivity(), ShowAllBookActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("data",categoryList);
        intent.putExtra("title",title);
        startActivity(intent);
    }

    public void setIntentPopular(ArrayList<Category>categoryList,String title){
        Intent intent = new Intent(getActivity(),PopularBookActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putParcelableArrayListExtra("data", categoryList);
        intent.putExtra("title", title);
        startActivity(intent);
    }


    @Override
    public void onResume() {
        super.onResume();

        View viewShelf = getLayoutInflater().inflate(R.layout.special_daynamic_layout,null);

        RecyclerView recyclerView = viewShelf.findViewById(R.id.recycler_container);

        AppCompatTextView textView = viewShelf.findViewById(R.id.txt_daynamic);

        RelativeLayout relativeLayout = viewShelf.findViewById(R.id.relative_bookmark);



        if (appDatabase.idao().categoryList().size() != 0) {

            HomeAdapter bookMarkAdapter = new HomeAdapter(appDatabase.idao().categoryList(),getActivity(),this::onClickReadingPdf);
            recyclerView.setAdapter(bookMarkAdapter);


            LinearLayoutManager manager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);

            recyclerView.setLayoutManager(manager);

            textView.setText("درحال خواندن");

            relativeLayout.setOnClickListener(view -> onClickReading((ArrayList<Category>) appDatabase.idao().categoryList(),"درحال خواندن"));



            binding.linearHomeFragment.addView(viewShelf);

        }else{

            binding.linearHomeFragment.removeView(viewShelf);
        }


    }

    public void onClickReading(ArrayList<Category>categoryList,String title){
        Intent intent = new Intent(getActivity(), ShowAllBookActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("data",categoryList);
        intent.putExtra("title",title);
        startActivity(intent);
    }

    public void onClickReadingPdf(Category category){
        Intent intent = new Intent(getActivity(), PdfBookActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("data",category);
        startActivity(intent);
    }

}