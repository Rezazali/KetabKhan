package com.book.fidibo.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.book.fidibo.R;
import com.book.fidibo.activity.BookDetailActivity;
import com.book.fidibo.activity.PdfBookActivity;
import com.book.fidibo.adapter.CategoryAdapter;
import com.book.fidibo.adapter.LibraryAdapter;
import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.FragmentLibrayBinding;
import com.book.fidibo.models.Category;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;

import java.util.Objects;


public class LibraryFragment extends Fragment implements CategoryAdapter.UserOnClickListener {


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


 /*        AppCompatButton btn =requireActivity().findViewById(R.id.btn_more);

         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 BottomSheetDialog dialog = new BottomSheetDialog(getActivity(),R.style.BottomSheetDialogTheme);
                 View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.layout_bottom_sheet,null);
                 dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);

                 dialog.setContentView(view1);

                 dialog.show();
             }
         });*/



        appDatabase = AppDatabase.getInstance(getActivity());
        setToolbar(binding.toolbar);
        setBottomSheet();

        return binding.getRoot();

    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }

  /*  @Override
    public void Category(Category category) {

    }*/

    public void setToolbar(Toolbar toolbar){
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        this.enableToolbar(false);
    }

    public void enableToolbar(boolean isValid){
        Objects.requireNonNull(((AppCompatActivity) requireActivity())
                        .getSupportActionBar())
                .setDisplayShowTitleEnabled(isValid);
    }


    public void setBottomSheet(){
    }

    @Override
    public void onResume() {
        super.onResume();
        CategoryAdapter adapter = new CategoryAdapter(appDatabase.idao().categoryList(),getActivity(), this);
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
}



