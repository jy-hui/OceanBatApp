package com.example.oceanbatapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class History extends AppCompatActivity {
    TextView d1, d2, d3, d4;
    String accountID;
    String services;
    String date;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        d1 = (TextView)findViewById(R.id.text_date1);
        d2 = (TextView)findViewById(R.id.text_date2);
        d3 = (TextView)findViewById(R.id.text_date3);
        d4 = (TextView)findViewById(R.id.text_date4);

        reff = FirebaseDatabase.getInstance().getReference().child("Booking Detail");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int n;
                //accountID = dataSnapshot.child(n).child("accountId").getValue(String.class);
                //services = dataSnapshot.child(n).child("services").getValue(String.class);
                //date = dataSnapshot.child(n).child("servicesDate").getValue(String.class);

                d1.setText(date);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
