package com.example.oceanbatapp;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public  class BookingPage extends AppCompatActivity {
        EditText mAddress, mBookD, mServicesD, mServicesT, mOther;
        Button Mbook;
        FirebaseAuth fAuth;
        FirebaseDatabase rootNode;
        DatabaseReference reference;
        String userID, Address, Book, ServicesD, ServicesT,Other;

        @SuppressLint("WrongViewCast")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.booking);

                mAddress = findViewById(R.id.booking_address_field);
                mBookD = findViewById(R.id.Booking_date);
                mServicesD = findViewById(R.id.services_date);
                mServicesT = findViewById(R.id.services_time_text);
                mOther = findViewById(R.id.extra_info_text);
                Mbook = findViewById(R.id.Book_button);

                fAuth = FirebaseAuth.getInstance();

                Mbook.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                Address = mAddress.getText().toString().trim();
                                Book = mBookD.getText().toString().trim();
                                ServicesD = mServicesD.getText().toString().trim();
                                ServicesT = mServicesT.getText().toString().trim();
                                Other = mOther.getText().toString().trim();

                                if (TextUtils.isEmpty((Address))) {
                                        mAddress.setError("address is required");
                                        return;
                                } else if (TextUtils.isEmpty((Book))) {
                                        mBookD.setError("Booking date is required");
                                        return;
                                } else if (TextUtils.isEmpty((ServicesD))) {
                                        mServicesD.setError("Services date is Required");
                                        return;
                                } else if (TextUtils.isEmpty(ServicesT)) {
                                        mServicesT.setError("Services time is Required");
                                        return;
                                } else {
                                        // register user in firebase
                                        userID = fAuth.getCurrentUser().getUid();
                                        rootNode = FirebaseDatabase.getInstance();
                                        reference = rootNode.getReference("Booking").child(userID);
                                        reference.child("Address").setValue(Address);
                                        reference.child("Book").setValue(Book);
                                        reference.child("servicesDate").setValue(ServicesD);
                                        reference.child("ServicesTime").setValue(ServicesT);
                                        reference.child("Other Information").setValue(Other);
                                }
                        }
                });
        }
}
