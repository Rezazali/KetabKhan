package com.book.fidibo.fragment;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.ArraySet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.Toast;

import com.book.fidibo.R;
import com.book.fidibo.activity.BookMarkActivity;
import com.book.fidibo.activity.DownloadShelfActivity;
import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.FragmentShelfBinding;
import com.book.fidibo.models.Shelf;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;


public class ShelfFragment extends Fragment implements View.OnClickListener  {

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

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentShelfBinding.inflate(getLayoutInflater());

        appDatabase = AppDatabase.getInstance(getActivity());


        binding.txtNumberDownload.setText(String.valueOf(appDatabase.idao().categoryList().size()));
        binding.txtNumberBookMark.setText(String.valueOf(appDatabase.idao().bookMarkList().size()));
        Log.d("","");


        BottomSheetDialog dialog = new BottomSheetDialog(getActivity(),R.style.BottomSheetDialogTheme);

        View view1 = LayoutInflater.from(getActivity())
                .inflate(R.layout.layout_bottom_sheet_shelf,null);
        dialog.setContentView(view1);

        AppCompatEditText edt_text  =view1.findViewById(R.id.edt_shelf);

        AppCompatButton btn_cancel  =view1.findViewById(R.id.btn_cancle);

        AppCompatButton btn_add_shelf  =view1.findViewById(R.id.btn_add_shelf);







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



        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity(), R.style.BottomSheetDialogTheme);
        View view2 = LayoutInflater.from(getActivity())
                .inflate(R.layout.layout_bottom_sheet_shelf_delete,null);
        bottomSheetDialog.setContentView(view2);
        AppCompatTextView txt_delete_book  =view2.findViewById(R.id.txt_delete_book_shelf);


        Set<Integer> set = new HashSet<Integer>();
        btn_add_shelf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("", "");

                    //random for create an integer id for database
                    int reza = 0;


                    for (int i = 0; i <appDatabase.idao().shelfList().size(); i++) {

                       /* Log.d("","");
                        Random random = new Random();
                        reza = random.nextInt(15);
*/

                        List<Integer>integers = new ArrayList<>();
                        integers.add(1);
                        integers.add(2);
                        integers.add(3);
                        integers.add(4);
                        integers.add(5);

                        reza = integers.get(i);

                        txt_delete_book.setTag(R.id.txt_delete_book_shelf,""+reza);

                    }


                    String text = Objects.requireNonNull(edt_text.getText()).toString();
                    String temp = text + "" + reza;
                    Shelf shelf = new Shelf(temp,reza);


                    appDatabase.idao().insertShelf(shelf);


                    Toast.makeText(getActivity(), "" + text, Toast.LENGTH_SHORT).show();

                }
            });











            for (int i=0; i<appDatabase.idao().list().size(); i++){


                Log.d("","");

                View viewShelf = getLayoutInflater().inflate(R.layout.layout_daynamic_shelf,null);

                RecyclerView recyclerView = viewShelf.findViewById(R.id.recyclerView);

                AppCompatTextView textView = viewShelf.findViewById(R.id.txt_title_shelf_d);


                viewShelf.setTag(R.layout.layout_daynamic_shelf,"reza");


                AppCompatButton btn_more = viewShelf.findViewById(R.id.btn_more_shelf);
                AppCompatButton btn_more2 = viewShelf.findViewWithTag(R.id.btn_more_shelf);

/*
                HomeAdapter bookMarkAdapter = new HomeAdapter(appDatabase.idao().categoryList(),getActivity(),this);
                recyclerView.setAdapter(bookMarkAdapter);
*/


                LinearLayoutManager manager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);

                recyclerView.setLayoutManager(manager);

                binding.linearContainerShelf.setColumnCount(2);
                binding.linearContainerShelf.setOrientation(GridLayout.HORIZONTAL);

                Log.d("","");



                textView.setText(appDatabase.idao().list().get(i));
            /*    textView.setId(i);
                int id = textView.getId();*/

/*
                textView.setTag(R.id.txt_title_shelf_d,""+appDatabase.idao().listId().get(id));
*/

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.getTag(R.id.txt_title_shelf_d);
                    }
                });




                btn_more.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        bottomSheetDialog.show();

                    }
                });



                txt_delete_book.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.getTag(R.id.txt_delete_book_shelf);
                        textView.getTag(R.id.txt_title_shelf_d);
                        viewShelf.getTag(R.layout.layout_daynamic_shelf);

                        viewShelf.getId();

                        int id = 0;
                        for (int i=0; i<appDatabase.idao().list().size(); i++) {
                            id= appDatabase.idao().listId().get(i);

                        }

                        appDatabase.idao().deleteShelf(2);


                        Log.d(TAG, "onClick: ");

                    }
                });

                       /* for (int i = 0; i<=5; i++){
                            appDatabase.idao().deleteShelf(i);
                        }*/
                binding.linearContainerShelf.addView(viewShelf);

                Log.d("","");
            }



        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        return binding.getRoot();
    }


    @Override
    public void onClick(View view) {

    }


}