//package com.example.stevenjoy.tools;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
//import android.text.TextUtils;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.firebase.client.Firebase;
//import com.firebase.client.Firebase.AuthStateListener;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//
///**
// * Created by stevenjoy on 7/3/17.
// */
//
//public class LoginActivity extends AppCompatActivity {
//
//    private EditText eMail;
//    private EditText mPassWord;
//    private Button login;
//    private Button cancel;
//    private FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener mAuthListener;
//
//    @Override
//    protected void onCreate(Bundle savedInstances) {
//        super.onCreate(savedInstances);
//        setContentView(R.layout.activity_main);
//        Firebase.setAndroidContext(this);
//
//        mAuth= FirebaseAuth.getInstance();
//
//        eMail = (EditText) findViewById(R.id.editText);
//        mPassWord = (EditText) findViewById(R.id.editText2);
//
//        login = (Button) findViewById(R.id.button);
//
//        mAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//
//                if(firebaseAuth.getCurrentUser() !=null) {
//
//                    startActivity(new Intent(LoginActivity.this, HomeScreen.class));
//
//                }
//
//            }
//        };
//
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Signin();
//            }
//        });
//
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        mAuth.addAuthStateListener(mAuthListener);
//
//        //FirebaseUser currentUser = mAuth.getCurrentUser();
//        //updateUI(currentUser);
//    }
//
//
//    private void Signin() {
//        String email = eMail.getText().toString();
//        String password = mPassWord.getText().toString();
//
//        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
//            Toast.makeText(LoginActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
//        }
//
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d("String", "signInWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                          //  updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w("String", "signInWithEmail:failure", task.getException());
//                            Toast.makeText(LoginActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                          //  updateUI(null);
//                        }
//                    }
//                });
//
//
//
//    }
//}
