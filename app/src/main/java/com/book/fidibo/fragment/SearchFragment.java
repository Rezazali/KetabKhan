package com.book.fidibo.fragment;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;


import android.os.Parcelable;

import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.book.fidibo.activity.SearchBookByCategoryActivity;
import com.book.fidibo.activity.uiActivity.SearchViewActivity;

import com.book.fidibo.databinding.FragmentSearchBinding;
import com.book.fidibo.models.Category;
import com.book.fidibo.models.objectModel.CategoryModel;
import com.book.fidibo.requestBody.IResponseListener;
import com.book.fidibo.requestBody.WebServiceCaller;


import java.util.ArrayList;



public class SearchFragment extends Fragment {

    FragmentSearchBinding binding;




    WebServiceCaller webServiceCaller;
    public SearchFragment() {
        // Required empty public constructor
    }


    @SuppressLint("RtlHardcoded")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(getLayoutInflater());

        webServiceCaller = new WebServiceCaller();


        setToolbar(binding.searchToolbar);



        Log.d("","");


        binding.edtSearch.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), SearchViewActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });


        binding.relPrograming.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                CategoryModel model = (CategoryModel) ResponseMessage;
                ArrayList<Category>categoryList = (ArrayList<Category>) model.getCategoryList();

                String title = "برنامه نویسی";

                setIntent(categoryList,title);
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },2));




        binding.relGrowUp.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                CategoryModel model = (CategoryModel) ResponseMessage;
                ArrayList<Category>categoryList = (ArrayList<Category>) model.getCategoryList();

                String title = "توسعه فردی";

                setIntent(categoryList,title);
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },3));


        binding.relPhysiology.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                CategoryModel model = (CategoryModel) ResponseMessage;
                ArrayList<Category>categoryList = (ArrayList<Category>) model.getCategoryList();

                String title = "روانشناسی";

                setIntent(categoryList,title);
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },4));


        binding.relNovel.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                CategoryModel model = (CategoryModel) ResponseMessage;
                ArrayList<Category>categoryList = (ArrayList<Category>) model.getCategoryList();

                String title = "رمان";

                setIntent(categoryList,title);
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },5));


        binding.relNegotiation.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                CategoryModel model = (CategoryModel) ResponseMessage;
                ArrayList<Category>categoryList = (ArrayList<Category>) model.getCategoryList();

                String title = "مذاکره";

                setIntent(categoryList,title);

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },6));






        return binding.getRoot();

    }



    public void setToolbar(Toolbar toolbar){
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
    }
    public void setIntent(ArrayList<Category>categoryList,String title){

        Intent intent = new Intent(getActivity(),SearchBookByCategoryActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putParcelableArrayListExtra("data", (ArrayList<? extends Parcelable>) categoryList);
        intent.putExtra("title",title);
        startActivity(intent);
    }

}
