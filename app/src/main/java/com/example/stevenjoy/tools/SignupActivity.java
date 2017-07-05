package com.example.stevenjoy.tools;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.DriverManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
//import butterknife.InjectView;


/**
 * Created by stevenjoy on 6/29/17.
 */

public class SignupActivity  extends AppCompatActivity {


    public String first_name;
    public String last_Name;
    public String email;
    public String date_of_birth;
    public String address;
    public String city;
    public String state;
    public String phone;


    public SignupActivity() {

    }

    public SignupActivity(String full_name, String last_Name, String email, String date_of_birth,
                String address, String city, String state, String phone) {
        this.first_name=full_name;
        this.last_Name=last_Name;
        this.email=email;
        this.date_of_birth=date_of_birth;
        this.address=address;
        this.city=city;
        this.state=state;
        this.phone=phone;
    }


    @BindView(R.id.input_Fname) EditText _fname;
    @BindView(R.id.input_email) EditText _emailText;
    //@BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.btn_signup) Button _signupButton;
    @BindView(R.id.link_login) TextView _loginLink;

    @BindView(R.id.input_Lname) EditText _lname;
    @BindView(R.id.input_age) EditText _age;
    @BindView(R.id.input_Address) EditText _address;
    @BindView(R.id.input_city) EditText _city;
    @BindView(R.id.input_state) EditText _state;
    @BindView(R.id.input_Phone) EditText _phone;



    private Firebase mref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        Firebase.setAndroidContext(this);
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        mref= new Firebase("https://tools-aee24.firebaseio.com"); // add Users to create users object in json file

        //final Firebase usersRef = mref.child("users");
       // final Firebase usersRef = mref.child("users");
        //final Firebase newPostRef = mref.push();


        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // signup();
                if (validate() == true) {

//                    newPostRef.setValue(new SignupActivity(_fname.getText().toString(),_lname.getText().toString(),_emailText.getText().toString(),
//                            _age.getText().toString(),_address.getText().toString(),_city.getText().toString(),_state.getText().toString(),
//                            _phone.getText().toString()));

//                    mref.child("Fname").child("Lname").child("Email").child("Age").child("Adress").child("City").child("State").child("Phone");
//                    SignupActivity user1 = new SignupActivity(_fname.getText().toString(),_lname.getText().toString(),_emailText.getText().toString(),
//                            _age.getText().toString(),_address.getText().toString(),_city.getText().toString(),_state.getText().toString(),
//                            _phone.getText().toString());
//
//                    mref.setValue(user1);



//                    Map<String, SignupActivity> users = new HashMap<String, SignupActivity>();
//                    users.put(user.getUid(), new SignupActivity(_fname.getText().toString(),_lname.getText().toString(),_emailText.getText().toString(),
//                            _age.getText().toString(),_address.getText().toString(),_city.getText().toString(),_state.getText().toString(),
//                            _phone.getText().toString()));

//                    usersRef.setValue(users);

//                    usersRef.child("Profiles").setValue(new SignupActivity(_fname.getText().toString(),_lname.getText().toString(),_emailText.getText().toString(),
//                            _age.getText().toString(),_address.getText().toString(),_city.getText().toString(),_state.getText().toString(),
//                            _phone.getText().toString()));



                    Firebase mrefChild = mref.child("ID");
                    Firebase fNameChild = mref.child("fName");
                    Firebase lNameChild = mref.child("Lname");
                    Firebase emailChild = mref.child("Email");
                    Firebase ageChild = mref.child("Age");
                    Firebase addressChild = mref.child("Address");
                    Firebase cityChild = mref.child("City");
                    Firebase stateChild = mref.child("State");
                    Firebase phoneChild = mref.child("Phone");

                    mrefChild.push().setValue(user.getUid());
                    fNameChild.setValue(_fname.getText().toString());
                    lNameChild.setValue(_lname.getText().toString());
                    emailChild.setValue(_emailText.getText().toString());
                    ageChild.setValue(_age.getText().toString());
                    addressChild.setValue(_address.getText().toString());
                    cityChild.setValue(_city.getText().toString());
                    stateChild.setValue(_state.getText().toString());
                    phoneChild.setValue(_phone.getText().toString());

                    //insertDatabase();
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


    public void insertDatabase() {

        final String Fname = _fname.getText().toString();
        final String L_name = _lname.getText().toString();
        final String UserEmail = _emailText.getText().toString();
        final String UserAge = _age.getText().toString();
        final String UserAddress = _address.getText().toString();
        final String UserCity = _city.getText().toString();
        final String UserState = _state.getText().toString();
        //final String Userpassword = _passwordText.getText().toString();
        final String PhoneNum = _phone.getText().toString();


        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    // add password if needed later
                    insert(Fname, L_name, UserAge, UserAddress, UserCity, UserState, UserEmail, PhoneNum);
                    //insertLogin(UserEmail,Userpassword, Fname);
                    Log.d("String", "made it to new thread");


                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected void insert(String... params) {
        Log.d("String", params[0]);
        Log.d("String", params[1]);
        Log.d("String", params[2]);
        Log.d("String", params[3]);
        Log.d("String", params[4]);
        Log.d("String", params[5]);
        Log.d("String", params[6]);
        Log.d("String", params[7]);
        Log.d("String", params[8]);


        String sql = "INSERT INTO Table.users (Fname, Lname, Age, Address, City, State, Email, Password, Phone)" +
                " VALUES ('" + params[0] + "' , '" + params[1] + "', '" + params[2] + "', '" + params[3] + "', '" + params[4] +
                "', '" + params[5] + "', '" + params[6] + "', '" + params[7] + "','" + params[8] + "');";
        // String dbuserName = "root";
        // String dbpassword = "MPwlzJpOJOEDHBaa";
        try {
            Connection conn = DBConnection.doInBackground();
            if (conn != null) {
                Log.d("String","Connected to the database");
            }
            else {
                Log.d("String","not workign ");
            }
            // Class.forName("com.mysql.jdbc.Driver");
            // String url = "jdbc:mysql://35.188.56.186/tool-time?zeroDateTimeBehavior=convertToNull";
            // Connection c = DriverManager.getConnection(url, dbuserName, dbpassword);
            PreparedStatement st = conn.prepareStatement(sql);
            st.execute();
            st.close();
            //     c.close();
        }
        //catch (ClassNotFoundException e)  {
        //   e.printStackTrace();
        //}
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

