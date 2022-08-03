package com.book.fidibo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;

import android.view.View;

import android.widget.Toast;
import com.book.fidibo.R;
import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.ActivityFavoriteChooseBinding;
import com.book.fidibo.models.Category;
import com.book.fidibo.models.objectModel.CategoryModel;
import com.book.fidibo.requestBody.IResponseListener;
import com.book.fidibo.requestBody.WebServiceCaller;


import java.util.List;

public class FavoriteChooseActivity extends AppCompatActivity {

    ActivityFavoriteChooseBinding binding;

    AppDatabase appDatabase;

    WebServiceCaller webServiceCaller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavoriteChooseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        appDatabase = AppDatabase.getInstance(getApplicationContext());

        binding.imgBackToolbar.setOnClickListener(view -> onBackPressed());

        webServiceCaller = new WebServiceCaller();

        binding.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = binding.radioGruop.getCheckedRadioButtonId();

                if(id == R.id.radio5Bu4tton) {
                    Toast.makeText(getApplicationContext(), "روانشناسی", Toast.LENGTH_SHORT).show();

                }else if (id == R.id.radioButton){

                    Toast.makeText(getApplicationContext(), "برنامه نویسی", Toast.LENGTH_SHORT).show();

                    webServiceCaller.getBookByCategory(new IResponseListener() {
                        @Override
                        public void onSuccess(Object ResponseMessage) {

                            Log.d("","");
                            CategoryModel model = (CategoryModel) ResponseMessage;
                            List<Category> categoryList = model.getCategoryList();


                            appDatabase.idao().insertList(categoryList);



                           /* Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("name",categoryList);

                            SpecialFragment fragment = new SpecialFragment();
                            fragment.setArguments(bundle);*/


                        }

                        @Override
                        public void onFailure(String errorResponseMessage) {

                        }
                    },2);



                }else if (id == R.id.radioButto2n){
                    Toast.makeText(getApplicationContext(), "توسعه فردی", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}