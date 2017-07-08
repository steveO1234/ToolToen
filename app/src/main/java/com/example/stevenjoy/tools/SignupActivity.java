package com.example.stevenjoy.tools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by stevenjoy on 6/29/17.
 */

public class SignupActivity  extends AppCompatActivity {

    @BindView(R.id.input_Fname) EditText _fname;
    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.btn_signup) Button _signupButton;
    @BindView(R.id.link_login) TextView _loginLink;
    @BindView(R.id.input_Lname) EditText _lname;
    @BindView(R.id.input_age) EditText _age;
    @BindView(R.id.input_Address) EditText _address;
    @BindView(R.id.input_city) EditText _city;
    @BindView(R.id.input_state) EditText _state;
    @BindView(R.id.input_Phone) EditText _phone;


    private Firebase mref;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;

   // private DatabaseReference mDatabase;
    private String mUserId;

    private Map<String, String> users = new HashMap<String, String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        Firebase.setAndroidContext(this);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        // mDatabase = FirebaseDatabase.getInstance().getReference();

        if (mFirebaseUser == null) {
            // Not logged in, launch the Log In activity
            startActivity(new Intent(SignupActivity.this, MainActivity.class));

        } else {
            mUserId = mFirebaseUser.getUid();
        }

            // add Users to create users object in json file
            mref = new Firebase("https://tools-aee24.firebaseio.com/Users");

            _signupButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (validate() == true) {

                        users.put("Fname" ,_fname.getText().toString());
                        users.put("Lname" ,_lname.getText().toString());
                        users.put("Email" ,_emailText.getText().toString());
                        users.put("Age" ,_age.getText().toString());
                        users.put("Address" ,_age.getText().toString());
                        users.put("City" ,_city.getText().toString());
                        users.put("State" ,_state.getText().toString());
                        users.put("Phone" ,_phone.getText().toString());

                        mref.child(mUserId).push().
                                child("Profile").setValue(users);

                        // Log.d("String", "worked");
                    } else {
                        Log.d("String", "didnt work");
                    }
                }
            });
    }

    public boolean validate() {
        boolean valid = true;

        /** login validations necessary characters needed*/
        if (_fname.getText().toString().isEmpty() || _fname.getText().toString().length() < 3) {
            _fname.setError("enter your first name");
            valid = false;
        } else {
            _fname.setError(null);
        }

//        if (_lname.getText().toString().isEmpty()) {
//            _lname.setError("Enter your last name");
//            valid = false;
//        } else {
//            _lname.setError(null);
//        }
//
//        if (_emailText.getText().toString().isEmpty() ||
//                !android.util.Patterns.EMAIL_ADDRESS.matcher(_emailText.getText().toString()).matches()) {
//            _emailText.setError("enter a valid email address");
//            valid = false;
//        } else {
//            _emailText.setError(null);
//        }
//
//        if (_phone.getText().toString().length() < 10) {
//            _phone.setError("Enter a valid phone number including area code");
//            valid = false;
//        } else {
//            _phone.setError(null);
//        }

//        if (_passwordText.getText().toString().isEmpty() ||
//                _passwordText.getText().toString().length() < 4 || _passwordText.getText().toString().length() > 10) {
//            _passwordText.setError("between 4 and 10 alphanumeric characters");  // pop up screen for error
//            valid = false;
//        } else {
//            _passwordText.setError(null);
//        }

//        if (_age.getText().toString().isEmpty() || _age.getText().toString().length() > 3) {
//            _age.setError("Enter a valid age");
//            valid = false;
//        } else {
//            _age.setError(null);
//        }
//
//        if (_address.getText().toString().isEmpty()) {
//            _address.setError("Please enter Address");
//            valid = false;
//        } else {
//            _address.setError(null);
//        }
//
//        if (_city.getText().toString().isEmpty()) {
//            _city.setError("Please enter City");
//            valid = false;
//        } else {
//            _city.setError(null);
//        }
//
//        if (_state.getText().toString().isEmpty()) {
//            _state.setError("Please enter State");
//            valid = false;
//        } else {
//            _state.setError(null);
//        }
        return valid;
    }

}

