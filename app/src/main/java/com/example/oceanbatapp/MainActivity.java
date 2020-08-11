package com.example.oceanbatapp;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


    }

}