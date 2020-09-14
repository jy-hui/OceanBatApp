package com.example.oceanbatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements View.OnClickListener
    {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*TextView passC = findViewById(R.id.button_detail_car);
        TextView passM = findViewById(R.id.button_detail_motor);
        TextView passH = findViewById(R.id.button_detail_house);
        TextView passG = findViewById(R.id.button_detail_garden);*/

        final Button carDetail = findViewById(R.id.button_detail_car);
        final Button carBook = findViewById(R.id.button_book_car);
        carDetail.setOnClickListener(this);
        carBook.setOnClickListener(this);

        final Button motorDetail = findViewById(R.id.button_detail_motor);
        final Button motorBook = findViewById(R.id.button_book_motor);
        motorDetail.setOnClickListener(this);
        motorBook.setOnClickListener(this);

        final Button houseDetail = findViewById(R.id.button_detail_house);
        final Button houseBook = findViewById(R.id.button_book_house);
        houseDetail.setOnClickListener(this);
        houseBook.setOnClickListener(this);

        final Button gardenDetail= findViewById(R.id.button_detail_garden);
        final Button gardenBook = findViewById(R.id.button_book_garden);
        gardenDetail.setOnClickListener(this);
        gardenBook.setOnClickListener(this);

        /*String passCar = passC.getText().toString();
        String passMotor = passM.getText().toString();
        String passHouse = passH.getText().toString();
        String passGarden = passG.getText().toString();*/
    }

    /*public void logout(View view){
        FirebaseAuth.getInstance().signOut(); //logout
        startActivity(new Intent(getApplicationContext(), FirstPage.class));
        finish();
    }*/

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button_detail_car: {
                    Intent intent = new Intent(Home.this,DetailCar.class);
                    /*intent.putExtra("car", passCar);*/
                    startActivity(intent);
                    break;
                }
                case R.id.button_book_car:
                case R.id.button_book_motor:
                case R.id.button_book_house:
                case R.id.button_book_garden:{
                    Intent intent = new Intent(Home.this, BookingPage.class);
                    startActivity(intent);
                    break;
                }
                case R.id.button_detail_motor: {
                    Intent intent = new Intent(Home.this,DetailMotorcycle.class);
                    startActivity(intent);
                    break;
                }
                case R.id.button_detail_house: {
                    Intent intent = new Intent(Home.this,DetailHouse.class);
                    startActivity(intent);
                    break;
                }
                case R.id.button_detail_garden: {
                    Intent intent = new Intent(Home.this,DetailGarden.class);
                    startActivity(intent);
                    break;
                }
            }
        }
    }
