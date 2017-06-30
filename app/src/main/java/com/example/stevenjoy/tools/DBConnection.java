package com.example.stevenjoy.tools;
import android.content.Context;


/**
 * Created by stevenjoy on 6/29/17.
 */

import java.sql.*;

public class DBConnection {

    protected Connection doInBackground(Context... contexts) {

        Connection conn = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");
         //   String url = "jdbc:mysql://104.196.134.4/healthApp?zeroDateTimeBehavior=convertToNull";

            String userName = "root";
            String password = "Ateamhealth";
           // conn = DriverManager.getConnection(url, userName, password);

            return conn;
        } catch (Exception e) {
            return null;
        }
    }
}