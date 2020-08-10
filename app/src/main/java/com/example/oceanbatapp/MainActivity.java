package com.example.oceanbatapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText email,password;
     Button button;
     String Email,pass;
     String emailpatern= "[a-zA-Z0-9._-]+@[a-z]+\\+[a-z]+";

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_text,R.string.close_text);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Email = email.getText().toString();
                pass = password.getText().toString();

                if(Email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }else if(Email.matches(emailpatern)){
                    Toast.makeText(MainActivity.this, "Enter valid email    ", Toast.LENGTH_SHORT).show();
                }else if(pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }else if(pass.length()<8){
                    Toast.makeText(MainActivity.this, "Please Enter 8 Digit Password", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(MainActivity.this,Home.class );
                startActivity(intent);
            }
        });



    }
}