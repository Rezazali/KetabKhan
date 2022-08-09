package com.book.fidibo.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.book.fidibo.R;
import com.book.fidibo.activity.BookDetailActivity;
import com.book.fidibo.activity.FavoriteChooseActivity;
import com.book.fidibo.adapter.CategoryAdapter;
import com.book.fidibo.adapter.HomeAdapter;
import com.book.fidibo.adapter.SpecialChooseAdapter;
import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.FragmentSpecialBinding;
import com.book.fidibo.models.Category;
import com.book.fidibo.models.objectModel.CategoryModel;
import com.book.fidibo.requestBody.IResponseListener;
import com.book.fidibo.requestBody.WebServiceCaller;

import java.util.List;
import java.util.Objects;

public class SpecialFragment extends Fragment implements HomeAdapter.UserOnClickListener {

    FragmentSpecialBinding binding;
    WebServiceCaller webServiceCaller;

    AppDatabase appDatabase;

    List<Category> category;
    RecyclerView recyclerView;

    public SpecialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSpecialBinding.inflate(getLayoutInflater());

        appDatabase = AppDatabase.getInstance(getActivity());

/*        View view = getLayoutInflater().inflate(R.layout.special_daynamic_layout,null);

        recyclerView = view.findViewById(R.id.recycler_container);


        if (appDatabase.idao().specialCategoryList().size()== 0){

            binding.imgBookBox.setVisibility(View.VISIBLE);

        }else{
            binding.imgBookBox.setVisibility(View.GONE);

            SpecialChooseAdapter adapter = new SpecialChooseAdapter(appDatabase.idao().specialCategoryList(),getActivity());
            recyclerView.setAdapter(adapter);

            LinearLayoutManager manager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
            recyclerView.setLayoutManager(manager);

            binding.linearContainer.addView(view);
        }*/






/*
        category = requireActivity().getIntent().getParcelableArrayListExtra("data");
*/
      /*  Log.d("","");
        Bundle bundle = this.getArguments();
        if (category == null){

            binding.imgBookBox.setVisibility(View.VISIBLE);
        }else{
            Log.d("","");
            binding.imgBookBox.setVisibility(View.GONE);
            category = Objects.requireNonNull(bundle).getParcelableArrayList("data");
            binding.recyclerCategory.setVisibility(View.VISIBLE);


            CategoryAdapter adapter = new CategoryAdapter(category,getActivity(),this::onClick);
            binding.recyclerCategory.setAdapter(adapter);

            LinearLayoutManager manager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
            binding.recyclerCategory.setLayoutManager(manager);
        }*/





        binding.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FavoriteChooseActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });

        webServiceCaller = new WebServiceCaller();

        webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {


                CategoryModel model = (CategoryModel) ResponseMessage;
                List<Category> categoryList = model.getCategoryList();
                HomeAdapter homeAdapter = new HomeAdapter(categoryList,getActivity(),SpecialFragment.this);
                binding.recyclerJustFidibo.setAdapter(homeAdapter);

                LinearLayoutManager manager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false);
                binding.recyclerJustFidibo.setLayoutManager(manager);
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },8);



        webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {


                CategoryModel model = (CategoryModel) ResponseMessage;
                List<Category> categoryList = model.getCategoryList();
                HomeAdapter homeAdapter = new HomeAdapter(categoryList,getActivity(),SpecialFragment.this);
                binding.recyclerScroll.setAdapter(homeAdapter);

                LinearLayoutManager manager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false);
                binding.recyclerScroll.setLayoutManager(manager);
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },7);

        return binding.getRoot();

    }

    @Override
    public void onClick(Category category) {
        Intent intent = new Intent(getActivity(), BookDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("data",category);
        startActivity(intent);
    }
}