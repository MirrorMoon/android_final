package com.leafmaple.androidtraining.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.bumptech.glide.Glide;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(() -> {
            SharedPreferences sharedPreferences = getSharedPreferences("setting",MODE_PRIVATE);
            boolean isFirst = sharedPreferences.getBoolean("isFirst", true);
            if(isFirst){
                Intent intent = new Intent(LauncherActivity.this, IntroActivity.class);
                startActivity(intent);
                    sharedPreferences.edit().putBoolean("isFirst", false).apply();
            }else {
                Intent intent = new Intent(LauncherActivity.this, SplashActivity.class);
                startActivity(intent);
            }
            finish();
        },1000);
        Glide.with(this).load("http://5b0988e595225.cdn.sohucs.com/images/" +
                "20190831/05de49d16e374e9e997bc97fdf29b0cc.gif").preload();
    }
}