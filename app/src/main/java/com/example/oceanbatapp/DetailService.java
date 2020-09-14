package com.example.oceanbatapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class DetailService extends AppCompatActivity {
    //@Override

    /*FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mGetReference = mDatabase.getReference("Service");

    DatabaseReference second = mGetReference.child("Motor");*/
    FirebaseAuth auth;

    TextView detail, text;
    String t,d;
    FirebaseAuth fAuth;
    DatabaseReference reference;

    //CookieHandler Picasso;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_service);

        auth = FirebaseAuth.getInstance();
        text = (TextView) findViewById(R.id.text_service);
        detail = (TextView) findViewById(R.id.text_detail);
        //image = findViewById(R.id.image_service);

        reference = FirebaseDatabase.getInstance().getReference("Service");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String passS = getIntent().getStringExtra("pass");
                assert passS != null;
                if (passS.equals("car")) {
                    t = dataSnapshot.child("Car").child("text").getValue(String.class);
                    d = dataSnapshot.child("Car").child("detail").getValue(String.class);
                    text.setText(t);
                    detail.setText(d);
                    /*Picasso.get("image").load().into(image);*/
                } else if (passS.equals("motor")) {
                    t = dataSnapshot.child("Motorcycle").child("text").getValue(String.class);
                    d = dataSnapshot.child("Motorcycle").child("detail").getValue(String.class);
                    text.setText(t);
                    detail.setText(d);
                }
                else if(passS.equals("house")) {
                    t = dataSnapshot.child("House").child("text").getValue(String.class);
                    d = dataSnapshot.child("House").child("detail").getValue(String.class);
                    text.setText(t);
                    detail.setText(d);
                }
                else if(passS.equals("garden")) {
                    t = dataSnapshot.child("Garden").child("text").getValue(String.class);
                    d = dataSnapshot.child("Garden").child("detail").getValue(String.class);
                    text.setText(t);
                    detail.setText(d);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(DetailService.this, "Can't Get data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

