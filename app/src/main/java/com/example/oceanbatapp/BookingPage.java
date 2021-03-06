package com.example.oceanbatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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


        String userID, address,bookD,servicesD, mservicesT,moTher;
        FirebaseDatabase database;
        DatabaseReference ref,BK;
        EditText mAddress, mBookD, mServicesD, mServicesT, mOther,mServices;
        Button Mbooking;
        int maxid=0;
        Booking booking;
        FirebaseAuth fAuth;

        TextView receiver;

        //private Spinner spinner;

        @SuppressLint("WrongViewCast")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.booking);

               // spinner = findViewById(R.id.spinner_text);

                receiver = (TextView) findViewById(R.id.services_type_name_text);
                String passS = getIntent().getStringExtra("pass");
                assert passS != null;

                receiver.setText(passS);


                /*final List<String> Category = new ArrayList<>();
                Category.add("Car services Cleaning");
                Category.add("Motorcycle services Cleaning");
                Category.add("House services Cleaning");
                Category.add("Garden services Cleaning");

                //receiver.setText(servicesType);


                final ArrayAdapter<String> dataAdpter;
                dataAdpter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,Category);

                dataAdpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinner.setAdapter(dataAdpter);*/

                /*spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if(adapterView.getItemAtPosition(i).equals("Choose services")){}
                                else{
                                        ///
                                }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                });*/
               // mServices = findViewById(R.id.Services_text);
                mAddress = findViewById(R.id.booking_address_field);
                mBookD = findViewById(R.id.Booking_date);
                mServicesD = findViewById(R.id.services_date);
                mServicesT = findViewById(R.id.services_time_text);
                mOther = findViewById(R.id.extra_info_text);
                receiver = findViewById(R.id.services_type_name_text);

                fAuth = FirebaseAuth.getInstance();
                userID = fAuth.getCurrentUser().getUid();

                Mbooking = findViewById(R.id.Book_button);

                booking = new Booking();
                ref = database.getInstance().getReference().child("account").child("Booking List");

                ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if(dataSnapshot.exists()){
                                        maxid = (int) dataSnapshot.getChildrenCount();
                                        Toast.makeText(BookingPage.this, String.valueOf(maxid), Toast.LENGTH_SHORT).show();
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

                                address = mAddress.getText().toString().trim();
                                bookD = mBookD.getText().toString().trim();
                                servicesD = mServicesD.getText().toString().trim();
                                mservicesT = mServicesT.getText().toString().trim();


                                if(TextUtils.isEmpty((address))) {
                                        mAddress.setError("Address is required");
                                        return;
                                }
                                if(TextUtils.isEmpty((bookD))) {
                                        mBookD.setError("Book date is required");
                                        return;
                                }
                                if(TextUtils.isEmpty((servicesD))) {
                                        mServicesD.setError("Services date is required");
                                        return;
                                }
                                if(TextUtils.isEmpty((mservicesT))) {
                                        mServicesT.setError("Services time is required");
                                        return;
                                }


                                else {

                                        userID = fAuth.getCurrentUser().getUid();
                                        database = FirebaseDatabase.getInstance();
                                        ref = database.getReference("account").child(userID + 1).child("Booking List");

                                        ref.child(String.valueOf(maxid + 1)).setValue(booking);

                                        booking.setReceiver(receiver.toString());
                                        //  booking.setServices(mServices.getText().toString());
                                        booking.setAddress(mAddress.getText().toString());
                                        booking.setBookingDate(mBookD.getText().toString());
                                        booking.setServicesDate(mServicesD.getText().toString());
                                        booking.setServicesTime(mServicesT.getText().toString());
                                        booking.setOther(mOther.getText().toString());


                                        Toast.makeText(BookingPage.this, "Your services have been add.", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(BookingPage.this,Home.class);
                                        startActivity(intent);
                                }

                        }
                });
        }
}