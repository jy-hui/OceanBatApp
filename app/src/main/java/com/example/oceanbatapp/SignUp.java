package com.example.oceanbatapp;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        final Button Login = findViewById(R.id.signUp_button);
        Login.setOnClickListener(this);


}


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.signUp_button:{
                Toast.makeText(this, "Button sign up clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUp.this, FirstPage.class);
                startActivity(intent);
                break;
            }
        }
    }
}