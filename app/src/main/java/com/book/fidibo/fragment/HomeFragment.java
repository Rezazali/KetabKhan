package com.book.fidibo.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.book.fidibo.R;
import com.book.fidibo.activity.BookDetailActivity;
import com.book.fidibo.activity.PopularBookActivity;

import com.book.fidibo.activity.SearchBookByCategoryActivity;
import com.book.fidibo.activity.ShowAllBookActivity;
import com.book.fidibo.adapter.HomeAdapter;
import com.book.fidibo.databinding.FragmentHomeBinding;

import com.book.fidibo.models.Category;
import com.book.fidibo.models.objectModel.CategoryModel;
import com.book.fidibo.requestBody.IResponseListener;
import com.book.fidibo.requestBody.WebServiceCaller;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class HomeFragment extends Fragment implements HomeAdapter.UserOnClickListener {

    FragmentHomeBinding binding;
    WebServiceCaller webServiceCaller;
    private long mLastClickTime = 0;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(getLayoutInflater());
/*
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
*/
        binding.setVisibility.setVisibility(View.GONE);
        darkNight();
        webServiceCaller = new WebServiceCaller();
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


        binding.constrainPrograming.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {


                CategoryModel categoryModel = (CategoryModel) ResponseMessage;
                ArrayList<Category>categoryList = (ArrayList<Category>) categoryModel.getCategoryList();

                String title = "برنامه نویسی";
                setIntentShowMore(categoryList,title);
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },2));

        binding.constrainGrowUp.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {


                CategoryModel categoryModel = (CategoryModel) ResponseMessage;
                ArrayList<Category>categoryList = (ArrayList<Category>) categoryModel.getCategoryList();

                String title = "توسعه فردی";
                setIntentShowMore(categoryList,title);

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },3));

        binding.constrainPsychology.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {


                CategoryModel categoryModel = (CategoryModel) ResponseMessage;
                ArrayList<Category>categoryList = (ArrayList<Category>) categoryModel.getCategoryList();

                String title = "روانشناسی";
                setIntentShowMore(categoryList,title);

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },4));

        binding.constrainNovel.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                CategoryModel model = (CategoryModel) ResponseMessage;
                List<Category> categoryList2 = model.getCategoryList();

                CategoryModel categoryModel = (CategoryModel) ResponseMessage;
                ArrayList<Category>categoryList = (ArrayList<Category>) categoryModel.getCategoryList();

                String title = "رمان";
                setIntentShowMore(categoryList,title);

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },5));

        binding.constrainNegotiation.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {


                CategoryModel categoryModel = (CategoryModel) ResponseMessage;
                ArrayList<Category>categoryList = (ArrayList<Category>) categoryModel.getCategoryList();

                String title = "مذاکره";
                setIntentShowMore(categoryList,title);

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },6));











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





        return binding.getRoot();
    }



    public void getCategoryPrograming(){



        webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {
                binding.setVisibility.setVisibility(View.VISIBLE);
                binding.progressbar.setVisibility(View.GONE);
                ///cleanUp with interface
                Log.d("","");
                CategoryModel model = (CategoryModel) ResponseMessage;
                List<Category> categoryList = model.getCategoryList();

                HomeAdapter adapter = new HomeAdapter(categoryList,getActivity(),HomeFragment.this::onClick);

                binding.recyclerPrograming.setAdapter(adapter);

                LinearLayoutManager manager =
                        new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
                binding.recyclerPrograming.setLayoutManager(manager);

                Log.d("","");
            }

            @Override
            public void onFailure(String errorResponseMessage) {
                /*binding.setVisibility.setVisibility(View.GONE);*/
                Snackbar snackbar = Snackbar.make(requireView(),"اینترنت خود را چک نمایید",Snackbar.LENGTH_LONG);
                snackbar.show();
                binding.noConnection.setVisibility(View.GONE);
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
            }

            @Override
            public void onFailure(String errorResponseMessage) {
                /* isConnected(false);*/
                Snackbar snackbar = Snackbar.make(requireView(),"connect internet plase",Snackbar.LENGTH_LONG);
                snackbar.show();


            }
        },6);
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

    public void darkNight(){

        SharedPreferences sharedPreferences
                = requireActivity().getSharedPreferences(
                "sharedPrefs", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor
                = sharedPreferences.edit();
        final boolean isDarkModeOn
                = sharedPreferences
                .getBoolean(
                        "isDarkModeOn", false);

        // When user reopens the app
        // after applying dark/light mode
        if (isDarkModeOn) {
            AppCompatDelegate
                    .setDefaultNightMode(
                            AppCompatDelegate
                                    .MODE_NIGHT_YES);

        }
        else {
            AppCompatDelegate
                    .setDefaultNightMode(
                            AppCompatDelegate
                                    .MODE_NIGHT_NO);

        }

        binding.switchColor.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view)
                    {
                        // When user taps the enable/disable
                        // dark mode button
                        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                            return;
                        }
                        mLastClickTime = SystemClock.elapsedRealtime();

                        binding.switchColor.setEnabled(false);


                        if (isDarkModeOn) {

                            // if dark mode is on it
                            // will turn it off
                            AppCompatDelegate
                                    .setDefaultNightMode(
                                            AppCompatDelegate
                                                    .MODE_NIGHT_NO);
                            // it will set isDarkModeOn
                            // boolean to false
                            editor.putBoolean(
                                    "isDarkModeOn", false);
                            editor.apply();

                            // change text of Button
                            binding.switchColor.setChecked(
                                    true);
                        }
                        else {

                            // if dark mode is off
                            // it will turn it on
                            AppCompatDelegate
                                    .setDefaultNightMode(
                                            AppCompatDelegate
                                                    .MODE_NIGHT_YES);

                            // it will set isDarkModeOn
                            // boolean to true
                            editor.putBoolean(
                                    "isDarkModeOn", true);
                            editor.apply();

                            // change text of Button
                            binding.switchColor.setChecked(
                                    false);
                        }



                    }
                });


    }


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
}