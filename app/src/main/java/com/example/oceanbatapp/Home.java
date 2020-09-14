package com.example.oceanbatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

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



    }

    /*public void logout(View view){
        FirebaseAuth.getInstance().signOut(); //logout
        startActivity(new Intent(getApplicationContext(), FirstPage.class));
        finish();
    }*/

    @Override
    public void onClick(View view) {
        //String servicesName = "";
        //String servicesType = "";

        switch (view.getId()){
            case R.id.button_detail_car: {
                Intent intent = new Intent(Home.this,DetailService.class).putExtra("pass","car");
                startActivity(intent);
                break;
            }
            case R.id.button_detail_motor: {
                Intent intent = new Intent(Home.this,DetailService.class).putExtra("pass","motor");
                startActivity(intent);
                break;
            }
            case R.id.button_detail_house: {
                Intent intent = new Intent(Home.this,DetailService.class).putExtra("pass","house");
                startActivity(intent);
                break;
            }
            case R.id.button_detail_garden: {
                Intent intent = new Intent(Home.this,DetailService.class).putExtra("pass","garden");
                startActivity(intent);
                break;
            }
            case R.id.button_book_car://{
                //Intent intent = new Intent(Home.this,BookingPage.class);
                //servicesName= getString(R.string.text_car);
                //intent.putExtra(servicesName, servicesType);
                //startActivity(intent);
               // break;
         //   }
            case R.id.button_book_motor:
            case R.id.button_book_house:
            case R.id.button_book_garden:{
                Intent intent = new Intent(Home.this, BookingPage.class);
                startActivity(intent);
                break;
            }

        }
    }
}
