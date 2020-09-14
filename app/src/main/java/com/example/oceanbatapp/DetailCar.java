package com.example.oceanbatapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.CookieHandler;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class DetailCar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_car);
    }
}
    /*private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mGetReference = mDatabase.getReference("Service");
    private DatabaseReference first = mGetReference.child("Car");
    TextView pass, detail, price, text, workingDay, workingHour;
    ImageView image;
    FirebaseAuth fAuth;
    /*Button buttonCar = findViewById(R.id.button_detail_car);
    Button buttonGarden = findViewById(R.id.button_detail_garden);
    Button buttonHouse = findViewById(R.id.button_detail_house);
    Button buttonMotor = findViewById(R.id.button_detail_motor);*/
   /* private CookieHandler Picasso;

    Intent intent = getIntent();
    String buttonCar = intent.getStringExtra("car");
    String buttonGarden = intent.getStringExtra("garden");
    String buttonHouse = intent.getStringExtra("house");
    String buttonMotor = intent.getStringExtra("motor");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_car);

        text = (TextView) findViewById(R.id.text_service);
        detail = (TextView) findViewById(R.id.text_content);
        price = (TextView) findViewById(R.id.text_priceD);
        workingDay = (TextView) findViewById(R.id.text_wDD);
        workingHour = (TextView) findViewById(R.id.text_wHD);
        image = findViewById(R.id.image_service);
    }

    @Override
    public void onStart() {
        super.onStart();
        switch (buttonCar) {
            //reff = FirebaseDatabase.getInstance().getReference.child("Service").child("Car");
            first.addValueEventListener(new ValueEventListerner() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String text = dataSnapshot.child("text").getValue().toString();
                    String detail = dataSnapshot.child("detail").getValue().toString();
                    String price = dataSnapshot.child("price").getValue().toString();
                    String workingHour = dataSnapshot.child("workingHour").getValue().toString();
                    String workingDay = dataSnapshot.child("workingDay").getValue().toString();
                    text.setText(text);
                    detail.setText(detail);
                    price.setText(price);
                    workingDay.setText(workingDay);
                    workingHour.setText(workingHour);
                    Picasso.get("image").load().into(image);
                }
            });
        }
    }
}*/
