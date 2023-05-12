package com.example.graceunlimited;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Settings extends AppCompatActivity {
    private Switch myswitch;

    SavePref savePref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        savePref  = new SavePref(this);
        if(savePref.loadNightModeState()){
            setTheme(R.style.Theme2);
        }
        else setTheme(R.style.Theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_back);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        this.setTitle(Html.fromHtml("<font color='#ffffff'>Settings</font>"));


        myswitch =(Switch)findViewById(R.id.switchh);
        if(savePref.loadNightModeState()){
            myswitch.setChecked(true);
        }
        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    savePref.setNightModeSate(true);
                    setTheme(R.style.darkTheme);
                    setTheme(R.style.Theme2);


                }
                else{
                    savePref.setNightModeSate(false);
                    setTheme(R.style.AppTheme);
                    setTheme(R.style.Theme);

                }
                finish();
                restartApp();
            }
            public  void restartApp() {
                Intent i = new Intent(getApplication(), StartPoint.class);
                finish();
                startActivity(i);
            }
        });
    }

}