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

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*public class SignUp extends AppCompatActivity implements View.OnClickListener {*/
public class SignUp extends AppCompatActivity {
    EditText mFullName, mEmail, mPassword, mPhone,mBirthday,mRepassword;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        mRepassword = findViewById(R.id.rePassword_text);
        mBirthday = findViewById(R.id.input_text_date);
        mFullName = findViewById(R.id.text_input_name);
        mEmail = findViewById(R.id.text_input_email);
        mPassword = findViewById(R.id.text_input_password);
        mRegisterBtn = findViewById(R.id.signUp_button);

        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), Home.class));
            finish();
        }

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String Username = mFullName.getText().toString().trim();
                String Birthday = mBirthday.getText().toString().trim();
                String Repassword = mRepassword.getText().toString().trim();

                if(TextUtils.isEmpty((Username))) {
                    mFullName.setError("Name is required");
                    return;
                }
                if(TextUtils.isEmpty((Birthday))) {
                    mBirthday.setError("Birthday is required");
                    return;
                }
                if (TextUtils.isEmpty((email))) {
                    mEmail.setError("Email is Required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is Required");
                    return;
                }
                if (TextUtils.isEmpty(Repassword)) {
                    mPassword.setError("Password is Required");
                    return;
                }

                if (password.length() < 6) {
                    mPassword.setError("Password Must be >= 6 Character");
                    return;
                }

                // register user in firebase

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "User Created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Home.class));
                        } else {
                            Toast.makeText(SignUp.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

        /*final Button Login = findViewById(R.id.signUp_button);
        Login.setOnClickListener(this);*/
    }

}

/*
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.signUp_button:{
                Toast.makeText(this, "Button sign up clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUp.this, FirstPage.class);
                startActivity(intent);
                break;
            }
        }
    }
}

 */