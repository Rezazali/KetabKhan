package com.book.fidibo.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.book.fidibo.activity.PdfBookActivity;
import com.book.fidibo.adapter.CategoryAdapter;
import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.FragmentLibrayBinding;
import com.book.fidibo.models.Category;
import com.book.fidibo.requestBody.WebServiceCaller;

import java.util.Objects;


public class LibraryFragment extends Fragment implements CategoryAdapter.UserOnClickListener {

    WebServiceCaller webServiceCaller;
    FragmentLibrayBinding binding;
    AppDatabase appDatabase;

    public LibraryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLibrayBinding.inflate(getLayoutInflater());
        webServiceCaller = new WebServiceCaller();

        setToolbar(binding.toolbar);


        appDatabase = AppDatabase.getInstance(getActivity());


        return binding.getRoot();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CategoryAdapter adapter = new CategoryAdapter(appDatabase.idao().categoryList() ,getActivity(),
                LibraryFragment.this);
        binding.recyclerLibrary.setAdapter(adapter);

        adapter.notifyDataSetChanged();


        LinearLayoutManager manager =
                new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        binding.recyclerLibrary.setLayoutManager(manager);
    }

    @Override
    public void Category(Category category) {
        Intent intent = new Intent(getActivity(), PdfBookActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("data",category);
        startActivity(intent);
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

