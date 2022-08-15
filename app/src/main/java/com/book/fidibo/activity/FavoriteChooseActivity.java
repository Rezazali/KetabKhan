package com.book.fidibo.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import android.util.AttributeSet;
import android.util.Log;

import android.view.View;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.book.fidibo.R;
import com.book.fidibo.adapter.SpecialChooseAdapter;
import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.ActivityFavoriteChooseBinding;
import com.book.fidibo.fragment.SpecialFragment;
import com.book.fidibo.models.Category;
import com.book.fidibo.models.SpecialCategory;
import com.book.fidibo.models.objectModel.CategoryModel;
import com.book.fidibo.models.objectModel.SpecialCategoryModel;
import com.book.fidibo.requestBody.IResponseListener;
import com.book.fidibo.requestBody.WebServiceCaller;


import java.util.ArrayList;
import java.util.List;

public class FavoriteChooseActivity extends AppCompatActivity {

    ActivityFavoriteChooseBinding binding;

    AppDatabase appDatabase;

    WebServiceCaller webServiceCaller;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavoriteChooseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        appDatabase = AppDatabase.getInstance(getApplicationContext());


        View view1 = getLayoutInflater().inflate(R.layout.fragment_special,null);

        ConstraintLayout layout = view1.findViewById(R.id.linear_container);


        View view2 = getLayoutInflater().inflate(R.layout.special_daynamic_layout,null);

       /* recyclerView = view2.findViewById(R.id.card);*/

        binding.imgBackToolbar.setOnClickListener(view -> onBackPressed());

        webServiceCaller = new WebServiceCaller();

        binding.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = binding.radioGruop.getCheckedRadioButtonId();

                if(id == R.id.radio5Bu4tton) {

                    Log.d("","");
                    Toast.makeText(getApplicationContext(), "روانشناسی", Toast.LENGTH_SHORT).show();

                }else if (id == R.id.radioButton){

                    Toast.makeText(getApplicationContext(), "برنامه نویسی", Toast.LENGTH_SHORT).show();

                    webServiceCaller.getBookByCategorySpecial(new IResponseListener() {
                        @Override
                        public void onSuccess(Object ResponseMessage) {

                          /*  Log.d("","");
                            SpecialCategoryModel model = (SpecialCategoryModel) ResponseMessage;
                            List<SpecialCategory> categoryList = model.getSpecialCategories();

                            *//*appDatabase.idao().insertList(categoryList);*//*

                            Log.d("","");

                            SpecialChooseAdapter adapter = new SpecialChooseAdapter(categoryList,getApplicationContext());
                            recyclerView.setAdapter(adapter);

                            LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
                            recyclerView.setLayoutManager(manager);*/


                        /*    SpecialCategoryModel model = (SpecialCategoryModel) ResponseMessage;
                            ArrayList<SpecialCategory> categoryList = (ArrayList<SpecialCategory>) model.getSpecialCategories();

                            Log.d("","");
                            FragmentManager manager = getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = manager.beginTransaction();
                            SpecialFragment fragment = new SpecialFragment();
                            Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("data",categoryList);
                            fragment.setArguments(bundle);
                            fragmentTransaction.replace(R.id.constrain_special,fragment,"TAG_FRAGMENT").commit();*/



                           /* Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("name",categoryList);

                            SpecialFragment fragment = new SpecialFragment();
                            fragment.setArguments(bundle);*/


                        }

                        @Override
                        public void onFailure(String errorResponseMessage) {

                        }
                    },2);

                    Log.d("","");
                    layout.addView(view2);

                }else if (id == R.id.radioButto2n){
                    Toast.makeText(getApplicationContext(), "توسعه فردی", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}