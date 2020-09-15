package com.example.oceanbatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicMarkableReference;

/*public class SignUp extends AppCompatActivity implements View.OnClickListener {*/
public class SignUp extends AppCompatActivity {

    private static final String TAG = "SignUp";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    EditText mFullName, mEmail, mPassword, mPhoneNo, mBirthday, mRepassword;
    Button mRegisterBtn;
    Button loginButton;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String userID, email, password, Username, Birthday, phoneNo;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        mDisplayDate = (TextView) findViewById(R.id.input_text_date);
       // mBirthday = findViewById(R.id.input_text_date);
        mFullName = findViewById(R.id.text_input_name);
        mEmail = findViewById(R.id.text_input_email);
        mPassword = findViewById(R.id.text_input_password);
        mPhoneNo = findViewById(R.id.input_text_phone);
        mRegisterBtn = findViewById(R.id.signUp_button);
        fAuth = FirebaseAuth.getInstance();
        loginButton = findViewById(R.id.button_login);


        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        SignUp.this,
                        android.R.style.Theme_Translucent_NoTitleBar,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };

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
                Birthday =  mDisplayDate.getText().toString().trim();
                phoneNo = mPhoneNo.getText().toString().trim();
                String Repassword = mRepassword.getText().toString().trim();

                if(TextUtils.isEmpty((Username))) {
                    mFullName.setError("Name is required");
                    return;
                }
                else if(TextUtils.isEmpty((Birthday))) {
                    mDisplayDate.setError("Birthday is required");
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
                } else if (TextUtils.isEmpty(phoneNo)) {
                        mPassword.setError("Phone number is required");
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
                                reference.child("phoneNo").setValue(phoneNo);
                                Toast.makeText(SignUp.this, "User Created.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), Home.class));
                            } else {
                                Toast.makeText(SignUp.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }



                //get all the value


                UserHelperClass helperClass = new UserHelperClass(email, password, Username, Birthday, phoneNo);

              //  reference.setValue("Change the account data");
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this,ActivityLogin.class);
                startActivity(intent);
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