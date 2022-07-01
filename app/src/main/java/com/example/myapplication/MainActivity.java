package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(() -> {
            try {

                Thread.sleep(2000);
                runOnUiThread(() -> {
                    Intent intent = new Intent(MainActivity.this, signLnScreen.class);
                    startActivity(intent);
                    finish();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


}