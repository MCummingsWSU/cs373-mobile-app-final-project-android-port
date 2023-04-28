package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.app_start_button).setOnClickListener(view -> startActivity(new Intent(MainActivity.this, GameActivity.class)));
    }
}