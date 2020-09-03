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

import java.util.concurrent.atomic.AtomicMarkableReference;

/*public class SignUp extends AppCompatActivity implements View.OnClickListener {*/
public class SignUp extends AppCompatActivity {
    EditText mFullName, mEmail, mPassword, mPhone, mBirthday, mRepassword;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String userID, email, password, Username, Birthday;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        mRepassword = findViewById(R.id.text_input_rePassword);
        mBirthday = findViewById(R.id.input_text_date);
        mFullName = findViewById(R.id.text_input_name);
        mEmail = findViewById(R.id.text_input_email);
        mPassword = findViewById(R.id.text_input_password);
        mRegisterBtn = findViewById(R.id.signUp_button);

        fAuth = FirebaseAuth.getInstance();



        /*if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), Home.class));
            finish();
        }*/

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = mEmail.getText().toString().trim();
                password = mPassword.getText().toString().trim();
                Username = mFullName.getText().toString().trim();
                Birthday = mBirthday.getText().toString().trim();
                String Repassword = mRepassword.getText().toString().trim();

                if(TextUtils.isEmpty((Username))) {
                    mFullName.setError("Name is required");
                    return;
                }
                else if(TextUtils.isEmpty((Birthday))) {
                    mBirthday.setError("Birthday is required");
                    return;
                }else if (TextUtils.isEmpty((email))) {
                    mEmail.setError("Email is Required");
                    return;
                }else if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is Required");
                    return;
                }else if (TextUtils.isEmpty(Repassword)) {
                    mPassword.setError("Password is Required");
                    return;
                }else if (password.length() < 6) {
                    mPassword.setError("Password Must be >= 6 Character");
                    return;
                }
                else {


                    // register user in firebase

                    fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                userID = fAuth.getCurrentUser().getUid();
                                rootNode = FirebaseDatabase.getInstance();
                                reference = rootNode.getReference("account").child(userID);
                                reference.child("email").setValue(email);
                                reference.child("password").setValue(password);
                                reference.child("Username").setValue(Username);
                                reference.child("Birthday").setValue(Birthday);
                                Toast.makeText(SignUp.this, "User Created.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), Home.class));
                            } else {
                                Toast.makeText(SignUp.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }



                //get all the value


                UserHelperClass helperClass = new UserHelperClass(email, password, Username, Birthday);

              //  reference.setValue("Change the account data");
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