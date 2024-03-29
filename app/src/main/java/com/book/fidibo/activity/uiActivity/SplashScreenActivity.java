package com.book.fidibo.activity.uiActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.book.fidibo.MainActivity;
import com.book.fidibo.databinding.ActivitySplashScreenBinding;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {


    ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.lottie.animate().setDuration(2000).setStartDelay(2900);

        Handler handler = new Handler();
        handler.postDelayed(() -> {
           startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));
           finish();
        },3000);
    }
}