package com.example.oceanbatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public  class BookingPage extends AppCompatActivity {


        FirebaseDatabase database;
        DatabaseReference ref,BK;
        EditText mAddress, mBookD, mServicesD, mServicesT, mOther,mServices;
        Button Mbooking;
        int maxid=0;
        private String bk;


        Booking booking;

        @SuppressLint("WrongViewCast")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.booking);

                mServices = findViewById(R.id.Services_text);
                mAddress = findViewById(R.id.booking_address_field);
                mBookD = findViewById(R.id.Booking_date);
                mServicesD = findViewById(R.id.services_date);
                mServicesT = findViewById(R.id.services_time_text);
                mOther = findViewById(R.id.extra_info_text);

                Mbooking = findViewById(R.id.Book_button);

                booking = new Booking();
                ref = database.getInstance().getReference().child("Booking Detail");

                ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if(dataSnapshot.exists()){
                                        maxid = (int) dataSnapshot.getChildrenCount();
                                }else {
                                        ///
                                }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                });

                Mbooking.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                                booking.setServices(mServices.getText().toString());
                                booking.setAddress(mAddress.getText().toString());
                                booking.setBookingDate(mBookD.getText().toString());
                                booking.setServicesDate(mServicesD.getText().toString());
                                booking.setServicesTime(mServicesT.getText().toString());
                                booking.setOther(mOther.getText().toString());

                                ref.child(String.valueOf(maxid+1)).setValue(booking);
                        }
                });
        }


}