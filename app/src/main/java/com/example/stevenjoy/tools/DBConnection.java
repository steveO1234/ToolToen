package com.example.stevenjoy.tools;


import android.util.Log;

import java.sql.DriverManager;
import java.sql.Connection;



/**
 * Created by stevenjoy on 6/29/17.
 */

public class DBConnection {

    public static Connection doInBackground() {

        Connection conn = null;



        try {
            Class.forName("com.mysql.jdbc.Driver");
          //  String url = "jdbc:mysql://35.188.56.186/tool-time?zeroDateTimeBehavior=convertToNull";
            String url = "jdbc:mysql://35.188.56.186/tool-time?user=root&password=MPwlzJpOJOEDHBaa";

            String userName = "root";
            String password = "MPwlzJpOJOEDHBaa";
            conn = DriverManager.getConnection(url, userName, password);
            if (conn != null) {
                Log.d("String","Connected to the database");
            }
            else {
                Log.d("String","not workign ");
            }

            return conn;
        } catch (Exception e) {
            return null;
        }
    }
}