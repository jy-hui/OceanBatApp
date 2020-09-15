package com.example.oceanbatapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;


public class DetailService extends AppCompatActivity {

    TextView detail, text;
    ImageView image;
    String t,d;
    Button back, book;
    DatabaseReference reference;
    FirebaseStorage storage;
    StorageReference storageReference;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_service);

        text = (TextView) findViewById(R.id.text_service);
        detail = (TextView) findViewById(R.id.text_detail);
        image = (ImageView) findViewById(R.id.image_service);

        back = findViewById(R.id.button_back);
        book = findViewById(R.id.button_service_book);

        reference = FirebaseDatabase.getInstance().getReference("Service");
        storage = FirebaseStorage.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
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
                    StorageReference imageS = storageReference.child("cleaning_car.jpg");
                    imageS.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Picasso.get().load(uri).into(image);
                        }
                    });

                } else if (passS.equals("motor")) {
                    t = dataSnapshot.child("Motorcycle").child("text").getValue(String.class);
                    d = dataSnapshot.child("Motorcycle").child("detail").getValue(String.class);
                    text.setText(t);
                    detail.setText(d);
                    StorageReference imageS = storageReference.child("cleaning_motorcycle.jpg");
                    imageS.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Picasso.get().load(uri).into(image);
                        }
                    });
                }
                else if(passS.equals("house")) {
                    t = dataSnapshot.child("House").child("text").getValue(String.class);
                    d = dataSnapshot.child("House").child("detail").getValue(String.class);
                    text.setText(t);
                    detail.setText(d);
                    StorageReference imageS = storageReference.child("cleaning_house.jpeg");
                    imageS.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Picasso.get().load(uri).into(image);
                        }
                    });
                }
                else if(passS.equals("garden")) {
                    t = dataSnapshot.child("Garden").child("text").getValue(String.class);
                    d = dataSnapshot.child("Garden").child("detail").getValue(String.class);
                    text.setText(t);
                    detail.setText(d);
                    StorageReference imageS = storageReference.child("cleaning_garden.jpeg");
                    imageS.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Picasso.get().load(uri).into(image);
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(DetailService.this, "Can't Get data", Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(DetailService.this, Home.class);
                startActivity(intent);
            }
        });

        /*book.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                String passS = getIntent().getStringExtra("pass");
                assert passS != null;
                if (passS.equals("car")) {
                    Intent intent = new Intent(DetailService.this, BookingPage.class).putExtra("passB", "car");
                    startActivity(intent);
                } else if (passS.equals("motor")) {
                    Intent intent = new Intent(DetailService.this, BookingPage.class).putExtra("passB", "motor");
                    startActivity(intent);
                } else if (passS.equals("house")) {
                    Intent intent = new Intent(DetailService.this, BookingPage.class).putExtra("passB", "house");
                    startActivity(intent);
                } else if (passS.equals("garden")) {
                    Intent intent = new Intent(DetailService.this, BookingPage.class).putExtra("passB", "garden");
                    startActivity(intent);
                }
            }
        });*/

    }
}

