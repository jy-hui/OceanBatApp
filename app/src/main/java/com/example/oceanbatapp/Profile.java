package com.example.oceanbatapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Profile extends AppCompatActivity {

     EditText mName, mEmail, mBirthDate, mPhoneNo;
     ImageView mProfilePic;
     Button mUpdateBtn;
     DatabaseReference databaseReference;
     FirebaseUser user;




    String userID;
    String email;
    String password;
    String Username;
    String Birthday;
    String phoneNo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);


        mName = findViewById(R.id.profileName);
        mEmail = findViewById(R.id.profileEmail);
        mBirthDate = findViewById(R.id.profileBirthDate);
        mPhoneNo = findViewById(R.id.profilePhoneNo);
        mProfilePic = findViewById(R.id.profilePic);
        mUpdateBtn = findViewById(R.id.updateBtn);

        user = FirebaseAuth.getInstance().getCurrentUser();
        userID = user.getUid();

        databaseReference = FirebaseDatabase.getInstance().getReference("account");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               /* mName.setText("email" userHelperClass.getUsername());
                mEmail.setText(userHelperClass.getEmail());
                mBirthDate.setText(userHelperClass.getBirthday());
                mPhoneNo.setText(userHelperClass.getPhoneNo());

                */

                Username = dataSnapshot.child(userID).child("Username").getValue(String.class);
                email = dataSnapshot.child(userID).child("email").getValue(String.class);
                Birthday = dataSnapshot.child(userID).child("Brithday").getValue(String.class);
                phoneNo = dataSnapshot.child(userID).child("phoneNo").getValue(String.class);

                /*email = mEmail.getText().toString().trim();
                Username = mName.getText().toString().trim();
                Birthday =  mBirthDate.getText().toString().trim();
                phoneNo = mPhoneNo.getText().toString().trim();

                 */

                mName.setText(Username);
                mEmail.setText(email);
                mBirthDate.setText(Birthday);
                mPhoneNo.setText(phoneNo);





            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Profile.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

        mUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }



}
