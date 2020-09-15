package com.example.oceanbatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public  class BookingPage extends AppCompatActivity {



        FirebaseDatabase database;
        DatabaseReference ref,BK;
        EditText mAddress, mBookD, mServicesD, mServicesT, mOther,mServices;
        Button Mbooking;
        int maxid=0;
        Booking booking;
        String userID, t;
        FirebaseAuth fAuth;

        TextView receiver;

        private Spinner spinner;

        @SuppressLint("WrongViewCast")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.booking);

                spinner = findViewById(R.id.spinner_text);

                receiver = (TextView) findViewById(R.id.services_type_name_text);
                String passS = getIntent().getStringExtra("pass");
                assert passS != null;
                switch (passS) {
                        case "car":{
                                receiver.setText(passS);
                                break;}
                        case "motor":{
                                receiver.setText(passS);
                                break;}
                        case "house":{
                                receiver.setText(passS);
                                break;}
                        case "garden":{
                                receiver.setText(passS);
                                break;}
                }

                final List<String> Category = new ArrayList<>();
                Category.add("Car services Cleaning");
                Category.add("Motorcycle services Cleaning");
                Category.add("House services Cleaning");
                Category.add("Garden services Cleaning");

                final ArrayAdapter<String> dataAdpter;
                dataAdpter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,Category);

                dataAdpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinner.setAdapter(dataAdpter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if(adapterView.getItemAtPosition(i).equals("Choose services")){
                        }
                         else{

                         }
                         }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                });
                // mServices = findViewById(R.id.Services_text);
                mAddress = findViewById(R.id.booking_address_field);
                mBookD = findViewById(R.id.Booking_date);
                mServicesD = findViewById(R.id.services_date);
                mServicesT = findViewById(R.id.services_time_text);
                mOther = findViewById(R.id.extra_info_text);


                fAuth = FirebaseAuth.getInstance();

                Mbooking = findViewById(R.id.Book_button);

                booking = new Booking();
                ref = database.getInstance().getReference().child("account").child("Booking List");

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

                                userID = fAuth.getCurrentUser().getUid();
                                database = FirebaseDatabase.getInstance();
                                ref = database.getReference("account").child(userID).child("Booking List");

                                ref.child(String.valueOf(maxid + 1)).setValue(booking);

                                booking.setSpinner(receiver.getText().toString());
                                //  booking.setServices(mServices.getText().toString());
                                booking.setAddress(mAddress.getText().toString());
                                booking.setBookingDate(mBookD.getText().toString());
                                booking.setServicesDate(mServicesD.getText().toString());
                                booking.setServicesTime(mServicesT.getText().toString());
                                booking.setOther(mOther.getText().toString());


                                Toast.makeText(BookingPage.this, "Your services have been add.", Toast.LENGTH_SHORT).show();

                        }
                });
        }


}