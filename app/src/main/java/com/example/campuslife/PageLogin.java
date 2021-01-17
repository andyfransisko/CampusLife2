package com.example.campuslife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PageLogin extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent i = new Intent(PageLogin.this,Homepage.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_login);

        Button bLogin;

        //Page Login
        bLogin = (Button) findViewById(R.id.buttonLogin2);
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent pageLogin = new Intent(getApplicationContext(),Dashboard.class);
                startActivity(pageLogin);
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

    }
}
