package com.example.campuslife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent next1 = new Intent(MainActivity.this, Homepage.class);
                startActivity(next1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        },SPLASH_TIME_OUT);
    }


}
