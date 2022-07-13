package com.book.fidibo.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.book.fidibo.activity.SearchBookByCategoryActivity;
import com.book.fidibo.adapter.CategoryAdapter;
import com.book.fidibo.databinding.FragmentSearchBinding;
import com.book.fidibo.models.Category;
import com.book.fidibo.ui.WebServiceCaller;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment implements View.OnClickListener{

    FragmentSearchBinding binding;
    WebServiceCaller webServiceCaller;

    ArrayList<String> arrayList =new ArrayList<>();
    ArrayAdapter<String>adapter;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(getLayoutInflater());
        webServiceCaller = new WebServiceCaller();

        binding.relPrograming.setOnClickListener(this);
        binding.relGrowUp.setOnClickListener(this);
        binding.relPhysiology.setOnClickListener(this);



        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), SearchBookByCategoryActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}