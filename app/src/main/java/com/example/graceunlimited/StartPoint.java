package com.example.graceunlimited;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;


public class StartPoint extends AppCompatActivity {

    private static int Splash = 500;
    SavePref savePref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        savePref  = new SavePref(this);
        if(savePref.loadNightModeState()){
            setTheme(R.style.Theme2);
            setTheme(R.style.darkTheme);
        }


        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_point);
        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }



        new Handler().postDelayed(() -> {
            Intent homeIntent = new Intent(StartPoint.this, MainActivity.class);
            startActivity(homeIntent);
            overridePendingTransition(R.anim.fade_out,R.anim.fade_in);
            finish();
        },Splash);


    }
}