package com.example.graceunlimited;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import org.sufficientlysecure.htmltextview.HtmlTextView;

public class itemViewActivity extends AppCompatActivity {
    TextView textView;
    HtmlTextView htmlTextView;
    SavePref savePref;
    ItemsModel itemsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        savePref = new SavePref(this);
        if(savePref.loadNightModeState()){
            setTheme(R.style.Theme2);
        }
        else setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_back);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        this.setTitle(Html.fromHtml("<font color='#ffffff'>Grace Unlimited Revival Center</font>"));


        textView = findViewById(R.id.textTittle);
        htmlTextView = findViewById(R.id.textViewName);

        Intent intent = getIntent();

        if(intent.getExtras() != null){
            itemsModel = (ItemsModel) intent.getSerializableExtra("item");

            textView.setText(itemsModel.getName());
            htmlTextView.setHtml(itemsModel.getDesc());
        }
    }
}