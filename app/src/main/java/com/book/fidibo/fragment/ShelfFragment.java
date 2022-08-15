package com.book.fidibo.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.book.fidibo.R;
import com.book.fidibo.activity.BookMarkActivity;
import com.book.fidibo.activity.DownloadShelfActivity;
import com.book.fidibo.activity.uiActivity.BottomSheet;
import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.FragmentShelfBinding;
import com.book.fidibo.models.Shelf;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;


public class ShelfFragment extends Fragment {

    FragmentShelfBinding binding;
    AppDatabase appDatabase;

    public ShelfFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requireActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentShelfBinding.inflate(getLayoutInflater());

        appDatabase = AppDatabase.getInstance(getActivity());

        Shelf shelf =  new Shelf();



        View viewShelf =getLayoutInflater().inflate(R.layout.layout_daynamic_shelf,null);

        RecyclerView recyclerView  = viewShelf.findViewById(R.id.recyclerView);
        AppCompatTextView txt_title  = viewShelf.findViewById(R.id.txt_title_shelf_d);





        BottomSheetDialog dialog = new BottomSheetDialog(getActivity(),R.style.BottomSheetDialogTheme);

        View view1 = LayoutInflater.from(getActivity())
                .inflate(R.layout.layout_bottom_sheet_shelf,null);
        dialog.setContentView(view1);

        AppCompatEditText edt_text  =view1.findViewById(R.id.edt_shelf);

        AppCompatButton btn_cancel  =view1.findViewById(R.id.btn_cancle);

        AppCompatButton btn_add_shelf  =view1.findViewById(R.id.btn_add_shelf);









/*
        if (appDatabase.idao().isRowExistsShelf(shelf.getId())){

            binding.linearContainerShelf.addView(view);

            binding.linearContainerShelf.invalidate();

        }else{

            binding.linearContainerShelf.removeView(view);
        }
*/


        binding.constraintBookMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), BookMarkActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });


        binding.constraintDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), DownloadShelfActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("title","دانلود شده");
                startActivity(intent);



            }
        });


        binding.constraintChanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), DownloadShelfActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("title","کتاب های الکترونیکی");
                startActivity(intent);



            }
        });





        binding.btnAddShelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               dialog.show();


            }
        });

        btn_add_shelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("","");
                String text = edt_text.getText().toString();
/*
                Shelf shelf = new Shelf(text);
                appDatabase.idao().insertShelf(shelf);

                Toast.makeText(getActivity(), ""+text, Toast.LENGTH_SHORT).show();*/



                Log.d("","");
                binding.linearContainerShelf.addView(viewShelf);
            }
        });



        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        return binding.getRoot();
    }


}