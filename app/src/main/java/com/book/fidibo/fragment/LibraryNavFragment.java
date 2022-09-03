package com.book.fidibo.fragment;


import android.annotation.SuppressLint;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.book.fidibo.R;

import com.book.fidibo.databinding.FragmentNavLibrayBinding;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;


public class LibraryNavFragment extends Fragment {


    FragmentNavLibrayBinding binding;


    public LibraryNavFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNavLibrayBinding.inflate(getLayoutInflater());





        setToolbar(binding.toolbar);

      requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_library,new LibraryFragment()).commit();
     Objects.requireNonNull(binding.tabLayout.getTabAt(1)).select();


        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition()){

                    case 0:

                        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_library,new ShelfFragment()).commit();

                        break;

                    case 1:
                        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_library,new LibraryFragment()).commit();


                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return binding.getRoot();

    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


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



