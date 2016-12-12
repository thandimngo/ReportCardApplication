package com.example.admin.reportcardapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyDBHandler myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startActivityFunction(View v) {
        Intent intent = new Intent(MainActivity.this, Functions.class);
        startActivity(intent);
    }
}
