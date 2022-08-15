package com.book.fidibo.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.book.fidibo.R;
import com.book.fidibo.activity.BookDetailActivity;
import com.book.fidibo.adapter.CategoryAdapter;
import com.book.fidibo.adapter.LibraryAdapter;
import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.FragmentLibraryBinding;
import com.book.fidibo.databinding.FragmentNavLibrayBinding;
import com.book.fidibo.models.Category;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;


public class LibraryFragment extends Fragment implements CategoryAdapter.UserOnClickListener{


    FragmentLibraryBinding binding;
    AppDatabase appDatabase;

    public LibraryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLibraryBinding.inflate(getLayoutInflater());
        appDatabase = AppDatabase.getInstance(getActivity());
        // Inflate the layout for this fragment\

        setBottomSheet();
        return binding.getRoot();
    }


    public void setBottomSheet(){
        LibraryAdapter adapter = new LibraryAdapter(appDatabase.idao().categoryList(),getActivity(), this);
        binding.recyclerLibrary.setAdapter(adapter);


        LinearLayoutManager manager =
                new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false);
        binding.recyclerLibrary.setLayoutManager(manager);
    }


    @Override
    public void onResume() {
        super.onResume();

        setBottomSheet();


    }

    @Override
    public void Category(@NonNull Category category) {

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity(), R.style.BottomSheetDialogTheme);
        View view1 = LayoutInflater.from(getActivity())
                .inflate(R.layout.layout_bottom_sheet,null);
        bottomSheetDialog.setContentView(view1);

        Picasso.get().load(category.getBookThumbnailS()).into((ImageView) view1.findViewById(R.id.img_bottom_sheet));
        AppCompatTextView txt_title  =view1.findViewById(R.id.txt_title_bottom_sheet);
        AppCompatTextView txt_publisher  =view1.findViewById(R.id.txt_publisher_bottom_sheet);
        AppCompatTextView txt_info_bottom_sheet  =view1.findViewById(R.id.txt_information_bottom_sheet);
        AppCompatTextView txt_delete_book  =view1.findViewById(R.id.txt_delete_book);

        txt_title.setText(category.getBookTitle());
        txt_publisher.setText(category.getBookPublisher());

        txt_info_bottom_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BookDetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("data",category);
                startActivity(intent);
            }
        });

        txt_delete_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appDatabase.idao().deleteVideo(Integer.parseInt(category.getId()));


/*                File file = new File("/data/data/com.book.fidibo/files/downloads/");
                  file.delete();
                */

                setBottomSheet();
                bottomSheetDialog.cancel();
             /*   getActivity().finish();
                getActivity().overridePendingTransition(0, 0);
                getActivity().startActivity(getActivity().getIntent());
                getActivity().overridePendingTransition(0, 0);*/
            }
        });

        bottomSheetDialog.show();
    }
}