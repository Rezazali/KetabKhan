package com.book.fidibo;


import androidx.appcompat.app.AppCompatActivity;


import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;


import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import android.widget.Toast;

import com.book.fidibo.databinding.ActivityMainBinding;
import com.book.fidibo.fragment.HomeFragment;
import com.book.fidibo.fragment.LibraryFragment;
import com.book.fidibo.fragment.SearchFragment;
import com.book.fidibo.fragment.SpecialFragment;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Secure for Create ScreenShot

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Fixed portrait orientation


        this.setClickMenu();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Configuration configuration = getResources().getConfiguration();
            configuration.setLayoutDirection(new Locale("ltr"));
            getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        }




       getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new HomeFragment()).commit();
        binding.bottomNav.getMenu().findItem(R.id.bottom_home).setChecked(true);



    }

    public void setClickMenu(){
        binding.bottomNav.setOnItemSelectedListener(item -> {

          /*       switch (item.getItemId()){}
           *        if use switch in this case will be warning
           *        warning Resource IDs will be non-final by default in Android Gradle Plugin version 8.0,
           *        avoid using them in switch case statements
           */

                if(item.getItemId() == R.id.bottom_library){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new LibraryFragment()).commit();
                    binding.bottomNav.getMenu().findItem(R.id.bottom_library).setChecked(true);
                    }

                if(item.getItemId() == R.id.bottom_search) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new SearchFragment()).commit();
                   binding.bottomNav.getMenu().findItem(R.id.bottom_search).setChecked(true);
                }

               if(item.getItemId() == R.id.bottom_special) {
                   getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new SpecialFragment()).commit();
                   binding.bottomNav.getMenu().findItem(R.id.bottom_special).setChecked(true);
               }

               if(item.getItemId() == R.id.bottom_home) {
                   getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new HomeFragment()).commit();
                   binding.bottomNav.getMenu().findItem(R.id.bottom_home).setChecked(true);
               }
            return false;
        });

    }

    @Override
    public void onBackPressed() {


        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            finishAffinity();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "لطفا دوبار کلیک فرمایید", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(() -> doubleBackToExitPressedOnce=false, 2000);
    }


}