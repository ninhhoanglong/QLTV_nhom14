package com.btl_nhom14.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class btl_nhom14_splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btl_nhom14_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(btl_nhom14_splashActivity.this, btl_nhom14_activityLogin.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}