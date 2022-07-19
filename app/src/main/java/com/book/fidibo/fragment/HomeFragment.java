package com.book.fidibo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.book.fidibo.adapter.BookByCategoryAdapter;
import com.book.fidibo.databinding.FragmentHomeBinding;
import com.book.fidibo.models.Category;
import com.book.fidibo.models.objectModel.CategoryModel;
import com.book.fidibo.requestBody.IResponseListener;
import com.book.fidibo.requestBody.WebServiceCaller;

import java.util.List;
import java.util.Objects;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    WebServiceCaller webServiceCaller;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater());


        setToolbar(binding.toolbar);

        getCategoryPrograming();
        getCategoryGrowUp();
        getCategoryPsychology();


        return binding.getRoot();
    }



    public void getCategoryPrograming(){

        webServiceCaller = new WebServiceCaller();

        webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                ///cleanUp with interface
                CategoryModel model = (CategoryModel) ResponseMessage;
                List<Category> categoryList = model.getCategoryList();
                BookByCategoryAdapter adapter = new BookByCategoryAdapter(categoryList,getActivity());

                binding.recyclerPrograming.setAdapter(adapter);

                LinearLayoutManager manager =
                        new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
                binding.recyclerPrograming.setLayoutManager(manager);
            }

            @Override
            public void onFailure(String errorResponseMessage) {

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
                BookByCategoryAdapter adapter = new BookByCategoryAdapter(categoryList,getActivity());

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

                binding.txtPsychology.setVisibility(View.VISIBLE);


                ///cleanUp with interface
                CategoryModel model = (CategoryModel) ResponseMessage;
                List<Category> categoryList = model.getCategoryList();


                BookByCategoryAdapter adapter = new BookByCategoryAdapter(categoryList,getActivity());

                binding.recyclerPsychology.setAdapter(adapter);

                LinearLayoutManager manager =
                        new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
                binding.recyclerPsychology.setLayoutManager(manager);
            }

            @Override
            public void onFailure(String errorResponseMessage) {
            }
        },4);
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
}