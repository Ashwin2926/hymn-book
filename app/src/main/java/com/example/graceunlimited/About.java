package com.example.graceunlimited;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;

import org.sufficientlysecure.htmltextview.HtmlTextView;

public class About extends AppCompatActivity {
    SavePref savePref;
    HtmlTextView htmlTextView;
    String html = "It is with much pleasure that we present this first official Hymn Book for Grace Unlimited Revival Centre International Church.<br>" +
            "We wish to acknowledge with humility the fact that most of the hymns were taken from the A.F.M in Zimbabwe hymn book as they are in commonly sung  in most churches.<br>" +
            "Many thanks to Apostle A.Chikomo and Worship Unlimited Choir for coming up with song “The Ancient Gates” .Thanks to Ashwin Nyamainashe for the effort he put into producing the electronic version of the Hymn Book.<br>" +
            "This Hymn Book is a combination of Shona songs and English Songs. We urge those who sing these songs to sing with understanding and prayerfully so as to enjoy the spiritual nourishment here with.<br>" +
            "May The Lord Richly Bless you as you sing these songs<br>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        savePref = new SavePref(this);
        if(savePref.loadNightModeState()){
            setTheme(R.style.Theme2);
        }
        else setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_back);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        this.setTitle(Html.fromHtml("<font color='#ffffff'>About</font>"));


        htmlTextView = findViewById(R.id.about);
        htmlTextView.setHtml(html);
    }
}