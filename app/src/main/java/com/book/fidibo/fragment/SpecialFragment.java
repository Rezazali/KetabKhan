package com.book.fidibo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.book.fidibo.R;
import com.book.fidibo.databinding.FragmentSpecialBinding;

public class SpecialFragment extends Fragment {

    FragmentSpecialBinding binding;

    public SpecialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSpecialBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}