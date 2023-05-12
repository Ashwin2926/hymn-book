package com.example.graceunlimited;

import android.content.Context;
import android.content.SharedPreferences;

public class SavePref {
    SharedPreferences mySharedPref;

    public SavePref(Context context) {
        mySharedPref = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }

    //This will save theme state true or false
    public void setNightModeSate(Boolean state) {
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("NightMode", state);
        editor.commit();
    }

    //this will load the Night Mode state
    public Boolean loadNightModeState() {
        Boolean state = mySharedPref.getBoolean("NightMode", false);
        return state;
    }
}
