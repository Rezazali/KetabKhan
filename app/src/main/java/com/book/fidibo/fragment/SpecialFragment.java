package com.book.fidibo.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


import com.book.fidibo.R;
import com.book.fidibo.activity.BookDetailActivity;
import com.book.fidibo.activity.DynamicChooseActivity;
import com.book.fidibo.activity.FavoriteChooseActivity;
import com.book.fidibo.activity.ShowAllBookActivity;
import com.book.fidibo.adapter.HomeAdapter;
import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.FragmentSpecialBinding;
import com.book.fidibo.models.Category;


import com.book.fidibo.models.objectModel.CategoryModel;
import com.book.fidibo.requestBody.IResponseListener;
import com.book.fidibo.requestBody.WebServiceCaller;

import java.util.ArrayList;
import java.util.List;

public class SpecialFragment extends Fragment implements HomeAdapter.UserOnClickListener {

    FragmentSpecialBinding binding;
    WebServiceCaller webServiceCaller;

    AppDatabase appDatabase;



    public SpecialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSpecialBinding.inflate(getLayoutInflater());
        webServiceCaller = new WebServiceCaller();
        appDatabase = AppDatabase.getInstance(getActivity());




        Log.d("", "");
        for (int i = 0; i < appDatabase.idao().favoriteList().size(); i++) {

            int reza = appDatabase.idao().listIdFavorite().get(i);

            View view = getLayoutInflater().inflate(R.layout.special_daynamic_layout, null);
            AppCompatTextView text_Programing = view.findViewById(R.id.txt_daynamic);
            RecyclerView recyclerView_custom= view.findViewById(R.id.recycler_container);
            RelativeLayout relativeLayout = view.findViewById(R.id.relative_bookmark);

            if (reza == 1) {

                text_Programing.setText("برنامه نویسی");
                webServiceCaller.getBookByCategory(new IResponseListener() {
                    @Override
                    public void onSuccess(Object ResponseMessage) {


                        CategoryModel model = (CategoryModel) ResponseMessage;
                        List<Category> categoryList = model.getCategoryList();

                        HomeAdapter adapter = new HomeAdapter(categoryList,getActivity(),SpecialFragment.this);

                        recyclerView_custom.setAdapter(adapter);

                        LinearLayoutManager manager =
                                new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
                        recyclerView_custom.setLayoutManager(manager);


                        relativeLayout.setOnClickListener(view1 -> setIntentShowMore((ArrayList<Category>) categoryList,1));

                        Log.d("","");
                    }

                    @Override
                    public void onFailure(String errorResponseMessage) {

                    }
                },2);


                binding.linearFavorite.addView(view);

            }else if (reza == 2) {

                text_Programing.setText("توسعه فردی");

                webServiceCaller.getBookByCategory(new IResponseListener() {
                    @Override
                    public void onSuccess(Object ResponseMessage) {
                        ///cleanUp with interface



                        CategoryModel model = (CategoryModel) ResponseMessage;
                        List<Category> categoryList = model.getCategoryList();


                        HomeAdapter adapter = new HomeAdapter(categoryList,getActivity(),SpecialFragment.this);



                        recyclerView_custom.setAdapter(adapter);

                        LinearLayoutManager manager =
                                new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
                        recyclerView_custom.setLayoutManager(manager);


                        relativeLayout.setOnClickListener(view12 -> setIntentShowMore((ArrayList<Category>) categoryList,2));


                    }

                    @Override
                    public void onFailure(String errorResponseMessage) {
                    }
                },3);


                binding.linearFavorite.addView(view);
            }else if (reza == 3) {

                webServiceCaller.getBookByCategory(new IResponseListener() {
                    @Override
                    public void onSuccess(Object ResponseMessage) {
                        ///cleanUp with interface



                        CategoryModel model = (CategoryModel) ResponseMessage;
                        List<Category> categoryList = model.getCategoryList();


                        HomeAdapter adapter = new HomeAdapter(categoryList,getActivity(),SpecialFragment.this);



                        recyclerView_custom.setAdapter(adapter);

                        LinearLayoutManager manager =
                                new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
                        recyclerView_custom.setLayoutManager(manager);


                        relativeLayout.setOnClickListener(view13 -> setIntentShowMore((ArrayList<Category>) categoryList,3));

                    }

                    @Override
                    public void onFailure(String errorResponseMessage) {
                    }
                },4);


                binding.linearFavorite.addView(view);
            }else if (reza == 4) {

                webServiceCaller.getBookByCategory(new IResponseListener() {
                    @Override
                    public void onSuccess(Object ResponseMessage) {
                        ///cleanUp with interface



                        CategoryModel model = (CategoryModel) ResponseMessage;
                        List<Category> categoryList = model.getCategoryList();


                        HomeAdapter adapter = new HomeAdapter(categoryList,getActivity(),SpecialFragment.this);



                        recyclerView_custom.setAdapter(adapter);

                        LinearLayoutManager manager =
                                new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
                        recyclerView_custom.setLayoutManager(manager);

                        relativeLayout.setOnClickListener(view14 -> setIntentShowMore((ArrayList<Category>) categoryList,4));
                    }

                    @Override
                    public void onFailure(String errorResponseMessage) {
                    }
                },5);



                binding.linearFavorite.addView(view);
            }else if (reza == 5) {

                webServiceCaller.getBookByCategory(new IResponseListener() {
                    @Override
                    public void onSuccess(Object ResponseMessage) {
                        ///cleanUp with interface



                        CategoryModel model = (CategoryModel) ResponseMessage;
                        List<Category> categoryList = model.getCategoryList();


                        HomeAdapter adapter = new HomeAdapter(categoryList,getActivity(),SpecialFragment.this);



                        recyclerView_custom.setAdapter(adapter);

                        LinearLayoutManager manager =
                                new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
                        recyclerView_custom.setLayoutManager(manager);

                        relativeLayout.setOnClickListener(view15 -> setIntentShowMore((ArrayList<Category>) categoryList,5));

                    }

                    @Override
                    public void onFailure(String errorResponseMessage) {
                    }
                },6);


                binding.linearFavorite.addView(view);
            }




        }








        if (appDatabase.idao().bookMarkListSingle().size() != 0){

            View viewShelf = getLayoutInflater().inflate(R.layout.special_daynamic_layout, null);

            RecyclerView recyclerView = viewShelf.findViewById(R.id.recycler_container);

            AppCompatTextView textView = viewShelf.findViewById(R.id.txt_daynamic);

            RelativeLayout relativeLayout = viewShelf.findViewById(R.id.relative_bookmark);


            HomeAdapter bookMarkAdapter = new HomeAdapter(appDatabase.idao().bookMarkListSingle(),getActivity(),SpecialFragment.this);
            recyclerView.setAdapter(bookMarkAdapter);


            LinearLayoutManager manager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);

            recyclerView.setLayoutManager(manager);


            textView.setText("نشان شده ها");

            relativeLayout.setOnClickListener(view -> onClickBookMark((ArrayList<Category>) appDatabase.idao().bookMarkListSingle(),"نشان شده ها"));

            binding.linearBookmark.addView(viewShelf);

        }





        binding.btnFavorite.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), FavoriteChooseActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        });



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


        binding.imgBackJustFidibo.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                CategoryModel model = (CategoryModel) ResponseMessage;
                ArrayList<Category> categoryList = (ArrayList<Category>) model.getCategoryList();
                Intent intent = new Intent(getActivity(), ShowAllBookActivity.class);
                intent.putExtra("data",categoryList);
                startActivity(intent);

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },8));

        binding.imgBackOxford.setOnClickListener(view -> webServiceCaller.getBookByCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {

                CategoryModel model = (CategoryModel) ResponseMessage;
                ArrayList<Category> categoryList = (ArrayList<Category>) model.getCategoryList();
                Intent intent = new Intent(getActivity(), ShowAllBookActivity.class);
                intent.putExtra("data",categoryList);
                startActivity(intent);

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        },7));





        return binding.getRoot();

    }

    @Override
    public void onClick(Category category) {
        Intent intent = new Intent(getActivity(), BookDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("data",category);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();




    }

    public void setIntentShowMore(ArrayList<Category>categoryList , int id){
        Intent intent = new Intent(getActivity(), DynamicChooseActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("data",categoryList);
        intent.putExtra("id",id);
        startActivity(intent);
    }

    public void onClickBookMark(ArrayList<Category>categoryList,String title){
        Intent intent = new Intent(getActivity(), ShowAllBookActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("data",categoryList);
        intent.putExtra("title",title);
        startActivity(intent);
    }

}