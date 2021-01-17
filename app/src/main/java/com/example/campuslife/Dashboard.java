package com.example.campuslife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {


    BottomNavigationView navigation;
    FrameLayout frameLayout;

    //fragment
    private FHome F1;
    private FSchedules F2;
    private FCourses F3;
    private FProfile F4;

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard.this);
        builder.setMessage("Log Out From Campus Life ?");
        builder.setCancelable(true);
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent ia = new Intent(Dashboard.this,Homepage.class);
                startActivity(ia);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        //Intent i = new Intent(Dashboard.this,Homepage.class);
        //startActivity(i);
        //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);



        navigation = findViewById(R.id.bottomNavigation);
        frameLayout = findViewById(R.id.container);

        //fragment initialization
        F1 = new FHome();
        F2 = new FSchedules();
        F3 = new FCourses();
        F4 = new FProfile();

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //Switch case
                switch (menuItem.getItemId())
                {
                    case R.id.menu_home :
                        InitializeFragment(F1);
                        return true;

                    case R.id.menu_schedule :
                        InitializeFragment(F2);
                        return true;

                    case R.id.menu_course :
                        InitializeFragment(F3);
                        return true;

                    case R.id.menu_profile :
                        InitializeFragment(F4);
                        return true;

                        default:InitializeFragment(F1);
                            return true;
                }

                //return false;
            }
        });

    }


    private void InitializeFragment(Fragment fragment)
    {
        FragmentTransaction FT = getSupportFragmentManager().beginTransaction();
        FT.replace(R.id.container, fragment);
        FT.commit();
    }
}
