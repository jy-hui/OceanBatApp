package com.example.oceanbatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstPage extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);

        final Button Login = findViewById(R.id.button_login);
        final Button SignUp = findViewById(R.id.button_signUp);
        Login.setOnClickListener(this);
        SignUp.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_login: {
                Toast.makeText(this, "Button Login clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Home.class);
                startActivity(intent);
                break;
            }
            case R.id.button_signUp: {
                Toast.makeText(this, "Button Sign Up clicked", Toast.LENGTH_SHORT).show();
                break;
            }
    }
    }
}