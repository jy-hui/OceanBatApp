package com.example.oceanbatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity  {
    EditText  mEmail, mPassword;
    Button mLoginBtn;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mEmail = findViewById(R.id.text_input_email);
        mPassword = findViewById(R.id.text_input_password);
        mLoginBtn = findViewById(R.id.Login_button);
        progressBar = findViewById(R.id.progressBar);

        fAuth = FirebaseAuth.getInstance();

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if (TextUtils.isEmpty((email))) {
                    mEmail.setError("Email is Required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is Required");
                    return;
                }

                if (password.length() < 6) {
                    mPassword.setError("Password Must be >= 6 Character");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful()){
                         Toast.makeText(ActivityLogin.this,"Logged in successfully",Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(getApplicationContext(),Home.class));
                     }
                     else{
                         Toast.makeText(ActivityLogin.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                         progressBar.setVisibility(View.GONE);
                     }
                    }
                });

            }
        });
    }
}
/*@Override
    public void onClick(View view) {
//final Button Login = findViewById(R.id.Login_button);
        //Login.setOnClickListener(this);
implements View.OnClickListener
        switch (view.getId()) {
            case R.id.Login_button: {
                Toast.makeText(this, "Button Login clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ActivityLogin.this, Home.class);
                startActivity(intent);
                break;
            }
        }
    }*/