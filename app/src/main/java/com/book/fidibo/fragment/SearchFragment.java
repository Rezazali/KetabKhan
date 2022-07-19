package com.book.fidibo.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.book.fidibo.activity.SearchBookByCategoryActivity;
import com.book.fidibo.activity.uiActivity.SearchViewActivity;
import com.book.fidibo.databinding.FragmentSearchBinding;



public class SearchFragment extends Fragment implements View.OnClickListener{

    FragmentSearchBinding binding;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(getLayoutInflater());


        this.setToolbar(binding.toolbar);

        binding.relPrograming.setOnClickListener(this);
        binding.relGrowUp.setOnClickListener(this);
        binding.relPhysiology.setOnClickListener(this);

        binding.searchView.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), SearchViewActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });


        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), SearchBookByCategoryActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void setToolbar(Toolbar toolbar){
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
    }


}
