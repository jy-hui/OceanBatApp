package com.example.oceanbatapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
/*

public class ViewDatabase extends AppCompatActivity {
    private static final String TAG = "ViewDatabase";

    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;
    private String userID;
    TextView mName, mEmail, mBirthDate, mPhoneNo;

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_database);

        mListView = (ListView) findViewById(R.id.listview);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    toastMessage("Successfully signed out.");
                }
            }
        };

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void showData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            UserHelperClass userHelperClass = new UserHelperClass();
            userHelperClass.setUsername(ds.child(userID).getValue(UserHelperClass.class).getUsername());
            userHelperClass.setEmail(ds.child(userID).getValue(UserHelperClass.class).getEmail());
            userHelperClass.setBirthday(ds.child(userID).getValue(UserHelperClass.class).getBirthday());
            userHelperClass.setPhoneNo(ds.child(userID).getValue(UserHelperClass.class).getPhoneNo());

            Log.d(TAG, "showData: Username: " + userHelperClass.getUsername());
            Log.d(TAG, "showData: email: " + userHelperClass.getEmail());
            Log.d(TAG, "showData: Birthday: " + userHelperClass.getBirthday());
            Log.d(TAG, "showData: phoneNo: " + userHelperClass.getPhoneNo());

            ArrayList<String> array = new ArrayList<>();
            array.add(userHelperClass.getUsername());
            array.add(userHelperClass.getEmail());
            array.add(userHelperClass.getBirthday());
            array.add(userHelperClass.getPhoneNo());
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,array);
            mListView.setAdapter(adapter);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}


 */