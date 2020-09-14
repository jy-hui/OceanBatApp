package com.example.oceanbatapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class ShowProfile extends AppCompatActivity {
    TextView mName, mEmail, mBirthDate, mPhoneNo;
    ImageView mProfilePic;
    Button editBtn;
    DatabaseReference databaseReference;
    FirebaseUser user;
    Uri imageUri;
    FirebaseStorage storage;
    StorageReference storageReference;
    FirebaseAuth fAuth;



    String userID;
    String email;
    String password;
    String Username;
    String Birthday;
    String phoneNo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_profile);


        mName = findViewById(R.id.profileName);
        mEmail = findViewById(R.id.profileEmail);
        mBirthDate = findViewById(R.id.profileBirthDate);
        mPhoneNo = findViewById(R.id.profilePhoneNo);
        mProfilePic = findViewById(R.id.profilePic);
        editBtn = findViewById(R.id.editProfile);

        user = FirebaseAuth.getInstance().getCurrentUser();
        userID = user.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference("account");
        fAuth = FirebaseAuth.getInstance();

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        storageReference = FirebaseStorage.getInstance().getReference();

        StorageReference profileRef = storageReference.child("user/"+fAuth.getCurrentUser().getUid()+"/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(mProfilePic);
            }
        });


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
                Birthday = dataSnapshot.child(userID).child("Birthday").getValue(String.class);
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
                Toast.makeText(ShowProfile.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ShowProfile.this,Profile.class);
                startActivity(intent);
            }
        });

    }


}
