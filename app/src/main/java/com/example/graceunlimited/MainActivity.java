package com.example.graceunlimited;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ViewPager pager;
    TabLayout mTablayout;
    TabItem item1,item2;
    PagerAdapter adapter;
    SavePref savePref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        savePref = new SavePref(this);
        if(savePref.loadNightModeState()){
            setTheme(R.style.darkTheme);

        }
        else setTheme(R.style.AppTheme);



        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        this.setTitle(Html.fromHtml("<font color='#ffffff'><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grace Unlimited<br></b></font>"));


        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        pager = findViewById(R.id.viewPager);
        mTablayout = findViewById(R.id.tablayout);
        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);




        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        adapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,mTablayout.getTabCount());
        pager.setAdapter(adapter);


        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            } 
        });
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTablayout));

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Application Exit!");
        alertDialogBuilder
                .setMessage("Are you sure?")
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
//    @Override
//    public void onBackPressed() {
//
//// Below code calls on back button clicked so define anything in this will run on
//// back button.
//
//
//        AlertDialog.Builder BackAlertDialog = new AlertDialog.Builder(MainActivity.this);
//
//        BackAlertDialog.setTitle("Activity Exit Alert");
//
//        BackAlertDialog.setMessage("Are you sure want to exit ?");
//
//
//        BackAlertDialog.setPositiveButton("NO",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        //Cancel alert dialog box .
//                        dialog.cancel();
//                    }
//                });
//
//        BackAlertDialog.setNegativeButton("YES",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//
//
//
//                        //Exit from activity.
//                        finish();
//                    }
//                });
//
//        BackAlertDialog.show();
//
//        return;
//    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (item.getItemId() == R.id.menu1) {
            Toast.makeText(this, "Settings", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), Settings.class);
            startActivity(intent);

        } else if (item.getItemId() == R.id.about) {
            Toast.makeText(this, "About", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), About.class);
            startActivity(intent);

        }
        return false;


    }

}
