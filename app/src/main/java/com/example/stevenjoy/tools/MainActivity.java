package com.example.stevenjoy.tools;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.Firebase.AuthStateListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by stevenjoy on 7/3/17.
 */

public class MainActivity extends AppCompatActivity {

    private EditText eMail;
    private EditText mPassWord;
    private Button login;
    private Button cancel;
    private EditText setEmail;
    private EditText setPassword;
    private Button noAccount;
    private Button verify;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_main);
       // Firebase.setAndroidContext(this);

        mAuth = FirebaseAuth.getInstance();

        eMail = (EditText) findViewById(R.id.editText);
        mPassWord = (EditText) findViewById(R.id.editText2);
        setEmail = (EditText) findViewById(R.id.editText3);
        setPassword = (EditText) findViewById(R.id.editText4);

        login = (Button) findViewById(R.id.button);
        noAccount = (Button) findViewById(R.id.account_SignUp);
        verify = (Button) findViewById(R.id.verify_Email_Button);


        /** skipping login screen if user credentials are already answered*/
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    startActivity(new Intent(MainActivity.this, HomeScreen.class));
                    Log.d("TAG", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("TAG", "onAuthStateChanged:signed_out");
                }

            }
        };

        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEmail.setVisibility(View.VISIBLE);
                setPassword.setVisibility(View.VISIBLE);
                verify.setVisibility(View.VISIBLE);
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signIn(eMail.getText().toString(), mPassWord.getText().toString());
            }
        });

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createAccount(setEmail.getText().toString(), setPassword.getText().toString());
                setEmail.setVisibility(View.INVISIBLE);
                setPassword.setVisibility(View.INVISIBLE);
                verify.setVisibility(View.INVISIBLE);

            }
        });

    }




    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mAuth.addAuthStateListener(mAuthListener);

//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

//    private void updateUI(FirebaseUser user) {
//        if (user != null) {
//            Toast.makeText(MainActivity.this, "Fields are not empty", Toast.LENGTH_SHORT).show();
//
//        } else {
//            Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
//
//        }
//    }

    private void signIn(String email, String password) {
      //  String email = eMail.getText().toString();
      //  String password = mPassWord.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("String", "signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (task.isSuccessful()) {

                            startActivity(new Intent(MainActivity.this, HomeScreen.class));
//                            Log.w("String", "signInWithEmail:failed", task.getException());
//                            Toast.makeText(MainActivity.this, "Failed",
//                                    Toast.LENGTH_SHORT).show();
                        }

                        if (!task.isSuccessful()) {
                            Log.d("Tag", "signInWithEmail:failed", task.getException());
                            Toast.makeText(MainActivity.this, "Failed",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    private void sendEmailVerification() {
        // Disable button
        findViewById(R.id.verify_Email_Button).setEnabled(false);

        // Send verification email
        // [START send_email_verification]
        final FirebaseUser user = mAuth.getCurrentUser();
        user.sendEmailVerification()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // [START_EXCLUDE]
                        // Re-enable button
                        findViewById(R.id.verify_Email_Button).setEnabled(true);

                        if (task.isSuccessful()) {
                            Log.d("email", "sent");
                            Toast.makeText(MainActivity.this,
                                    "Verification email sent to " + user.getEmail(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Log.e("TAG", "sendEmailVerification", task.getException());
                            Toast.makeText(MainActivity.this,
                                    "Failed to send verification email.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        // [END_EXCLUDE]
                    }
                });
        // [END send_email_verification]
    }


    private boolean validateForm() {
        boolean valid = true;

        String email = eMail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            eMail.setError("Required.");
            valid = false;
        } else {
            eMail.setError(null);
        }

        String password = mPassWord.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPassWord.setError("Required.");
            valid = false;
        } else {
            mPassWord.setError(null);
        }

        return valid;
    }

    private boolean validateNewUser() {
        boolean valid = true;

        String email = setEmail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            eMail.setError("Required.");
            valid = false;
        } else {
            eMail.setError(null);
        }

        String password = setPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPassWord.setError("Required.");
            valid = false;
        } else {
            mPassWord.setError(null);
        }

        return valid;
    }

    private void createAccount(String email, String password) {
        Log.d("TAG", "createAccount:" + email);
        if (!validateNewUser()) {
            return;
        }
        //showProgressDialog();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("TAG1", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(MainActivity.this, "Success You May Now Login.",
                                    Toast.LENGTH_SHORT).show();
                         //  updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG1", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                          // updateUI(null);
                        }
                       // hideProgressDialog();
                    }
                });
    }
}