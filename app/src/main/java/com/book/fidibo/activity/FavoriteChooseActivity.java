package com.book.fidibo.activity;

import static android.content.ContentValues.TAG;


import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;


import android.util.Log;




import android.widget.Toast;
import com.book.fidibo.R;

import com.book.fidibo.database.AppDatabase;
import com.book.fidibo.databinding.ActivityFavoriteChooseBinding;

import com.book.fidibo.models.Favorite;


import com.book.fidibo.requestBody.WebServiceCaller;




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

        binding.btnApply.setOnClickListener(view -> {

            int id = binding.radioGruop.getCheckedRadioButtonId();

            if(id == R.id.radio_btn_programing) {

                Log.d(TAG, "onClick: ");
                if (appDatabase.idao().isRowExistsFavorite(1)){

                    Toast.makeText(getApplicationContext(), "قبلا انتخاب شده است  ", Toast.LENGTH_SHORT).show();

                }else {

                    Log.d(TAG, "onClick: ");
                    Favorite favorite = new Favorite(1,"Programing");
                    appDatabase.idao().insertFavorite(favorite);

                }



            }else if (id == R.id.radio_btn_growUp){

                Log.d(TAG, "onClick: ");

                if (appDatabase.idao().isRowExistsFavorite(2)){

                    Toast.makeText(getApplicationContext(), "قبلا انتخاب شده است  ", Toast.LENGTH_SHORT).show();
                }else{
                    Favorite favorite = new Favorite(2,"growUp");
                    appDatabase.idao().insertFavorite(favorite);
                }




            }else if (id == R.id.radio_btn_physiology){


                if (appDatabase.idao().isRowExistsFavorite(3)){

                    Toast.makeText(getApplicationContext(), "قبلا انتخاب شده است  ", Toast.LENGTH_SHORT).show();
                }else{
                    Favorite favorite = new Favorite(3,"growUp");
                    appDatabase.idao().insertFavorite(favorite);
                }


            }else if (id == R.id.radio_btn_novel){


                if (appDatabase.idao().isRowExistsFavorite(4)){

                    Toast.makeText(getApplicationContext(), "قبلا انتخاب شده است  ", Toast.LENGTH_SHORT).show();
                }else{
                    Favorite favorite = new Favorite(4,"growUp");
                    appDatabase.idao().insertFavorite(favorite);
                }


            }else if (id == R.id.radio_btn_negotiation){


                if (appDatabase.idao().isRowExistsFavorite(5)){

                    Toast.makeText(getApplicationContext(), "قبلا انتخاب شده است  ", Toast.LENGTH_SHORT).show();
                }else{
                    Favorite favorite = new Favorite(5,"growUp");
                    appDatabase.idao().insertFavorite(favorite);
                }


            }

            Toast.makeText(FavoriteChooseActivity.this, "با موفقیت اضافه شد", Toast.LENGTH_SHORT).show();
            finish();
        });

    }


}