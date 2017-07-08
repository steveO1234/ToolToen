package com.example.stevenjoy.tools;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by stevenjoy on 7/5/17.
 */

public class Users {


    public String first_name;
    public String last_Name;

    public String email;
    public String date_of_birth;
    public String address;
    public String city;
    public String state;
    public String phone;
    //private Firebase mref;


    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirst_name() {

        return first_name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public String getEmail() {
        return email;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }



    public Users(String full_name, String last_Name, String email, String date_of_birth,
                 String address, String city, String state, String phone) {
        this.first_name = full_name;
        this.last_Name = last_Name;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phone = phone;
    }


    //final Firebase usersRef = mref.child("users");

    //  Firebase.setAndroidContext(this);
    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    //Firebase.setAndroidContext(this);

    Firebase alanRef = new Firebase("https://mybabysit.firebaseio.com/");
    //alanRef.child("users").child("alanisawesome");
    //Users alan = new Users("Alan Turing", 1912);
    //alanRef.setValue(alan);

}