package com.example.stevenjoy.tools;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by stevenjoy on 7/3/17.
 */

public class tools extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
