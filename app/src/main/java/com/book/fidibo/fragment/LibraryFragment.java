package com.book.fidibo.fragment;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.book.fidibo.activity.PdfBookActivity;
import com.book.fidibo.adapter.CategoryAdapter;
import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.FragmentLibrayBinding;
import com.book.fidibo.models.Category;
import com.book.fidibo.ui.WebServiceCaller;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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

        ((AppCompatActivity) requireActivity()).setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(((AppCompatActivity) requireActivity())
                .getSupportActionBar()).
                setDisplayShowTitleEnabled(false);

        appDatabase = AppDatabase.getInstance(getActivity());
        runTimePermission();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CategoryAdapter adapter = new CategoryAdapter(appDatabase.idao().categoryList() ,getActivity(),
                LibraryFragment.this);
        binding.recyclerLibrary.setAdapter(adapter);



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
    public void runTimePermission(){

        Dexter.withContext(getActivity()).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();
    }



}