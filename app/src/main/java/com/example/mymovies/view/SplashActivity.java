package com.example.mymovies.view;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;

import com.bumptech.glide.Glide;
import com.example.mymovies.R;
import com.example.mymovies.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        Glide.with(this).asGif().load(R.drawable.splash_image).into(binding.splashLogo);

        new Handler().postDelayed(()-> {

            Intent intent = new Intent(this, MainActivity.class);

            getWindow().setExitTransition(new Slide(Gravity.LEFT));
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

        },4000);

    }
}