package com.example.oceanbatapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;

import android.text.style.TtsSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputPassword;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);



        textInputEmail = findViewById(R.id.text_input_email);
        textInputPassword = findViewById(R.id.text_input_password);
    }
    private boolean validateEmail(){
        String emailInput;
        emailInput =(textInputEmail.getEditText()).getText().toString().trim();

        if (emailInput.isEmpty()){
            textInputEmail.setError("Field can't be empty");
            return false;
        }else{
            textInputEmail.setError(null);
            return true;
        }
    }

    private boolean validatePassword(){
        String PasswordInput = textInputPassword.getEditText().getText().toString().trim();

        if (PasswordInput.isEmpty()){
            textInputPassword.setError("Field can't be empty");
            return false;
        }else{
            textInputPassword.setError(null);
            return true;
        }
    }
    public void confirmInput(View v) {
        if(!validateEmail()|!validatePassword()){
            return;
        }
        String input = "Email :" + textInputEmail.getEditText().getText().toString() + "\n";
        input += "Password" +textInputPassword.getEditText().getText().toString();
        input +="\n";
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }

}