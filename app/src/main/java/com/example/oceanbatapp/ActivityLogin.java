package com.example.oceanbatapp;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity implements View.OnClickListener {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final Button Login = findViewById(R.id.Login_button);
        Login.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.Login_button: {
                Toast.makeText(this, "Button Login clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ActivityLogin.this, Home.class);
                startActivity(intent);
                break;
            }
        }
    }
}