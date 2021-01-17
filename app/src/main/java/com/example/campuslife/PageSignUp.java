package com.example.campuslife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class PageSignUp extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent i = new Intent(PageSignUp.this,Homepage.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_sign_up);
    }
}
