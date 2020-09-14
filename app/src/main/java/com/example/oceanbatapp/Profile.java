package com.example.oceanbatapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Profile extends AppCompatActivity {

     EditText mName, mEmail, mBirthDate, mPhoneNo;
     ImageView mProfilePic;
     Button mUpdateBtn;
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
                Toast.makeText(Profile.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

        mProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosePicture();
            }
        });

        //update data
        mUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = mEmail.getText().toString();
                Username = mName.getText().toString();
                Birthday =  mBirthDate.getText().toString();
                phoneNo = mPhoneNo.getText().toString();

                HashMap hashMap= new HashMap();
                hashMap.put("Username",Username);
                hashMap.put("email",email);
                hashMap.put("Birthday",Birthday);
                hashMap.put("phoneNo",phoneNo);

                databaseReference.child(userID).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(Profile.this, "Your Data is Successfully Updated", Toast.LENGTH_SHORT).show();
                    }
                });

                Intent intent = new Intent(Profile.this,ShowProfile.class);
                startActivity(intent);

            }


        });



    }


    private void choosePicture(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null ){
            imageUri = data.getData();

            //mProfilePic.setImageURI(imageUri);

            //uploadPicture();

            uploadPictureToFirebase(imageUri);
        }
    }

    private void uploadPictureToFirebase(Uri imageUri) {
        // upload image to firebase storage
        final StorageReference fileRef = storageReference.child("user/"+fAuth.getCurrentUser().getUid()+"/profile.jpg");
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                //Toast.makeText(Profile.this, "Image Uploaded", Toast.LENGTH_SHORT).show();
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).into(mProfilePic);
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Profile.this, "Failed.", Toast.LENGTH_SHORT).show();
            }
        });
    }



    /*private void uploadPicture() {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Uploading Image...");
        pd.show();

        final String randomKey = UUID.randomUUID().toString();
        StorageReference riversRef = storageReference.child("images/" + randomKey);

        riversRef.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        pd.dismiss();
                        Snackbar.make(findViewById(android.R.id.content), "Image Upload.", Snackbar.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        pd.dismiss();
                        Toast.makeText(getApplicationContext(), "Failed To Upload", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                        double progressPercent = (100.00 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                        pd.setMessage("Progress: " + (int) progressPercent + "%");
                    }
                });


    }

     */
}
