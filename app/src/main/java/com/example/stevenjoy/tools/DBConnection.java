package com.example.stevenjoy.tools;


import android.util.Log;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by stevenjoy on 6/29/17.
 */

public class DBConnection {

    public static Connection doInBackground() {

        Connection conn = null;


        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // String url = "jdbc:mysql://104.196.99.250/tooltime?zeroDateTimeBehavior=convertToNull";
            String url = "jdbc:mysql://104.196.99.250/tool-time?user=root&password=LgIyBBfl8eekfJ7m";

            String userName = "root";
            String password = "LgIyBBfl8eekfJ7m";
            conn = DriverManager.getConnection(url, userName, password);
            //   conn = DriverManager.doInBackground("jdbc:mysql://35.188.56.186/tool-time", "root", "MPwlzJpOJOEDHBaa");

            return conn;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return conn;
    }
}


//    private static String url = "jdbc:mysql://104.196.99.250:3306";
//    private static String driverName = "com.mysql.jdbc.Driver";
//    private static String username = "root";
//    private static String password = "LgIyBBfl8eekfJ7m";
//    private static Connection con;
//
//
//    public static Connection doInBackground() {
//        try {
//            Class.forName(driverName).newInstance();
//            try {
//                if(con !=null)
//                    return con;
//                else
//                    return con = DriverManager.getConnection(url, username, password);
//            } catch (SQLException ex) {
//                // log an exception. for example:
//                Log.d("String","Failed to create the database connection.");
//            }
//        } catch (ClassNotFoundException ex) {
//            // log an exception. for example:
//            Log.d("String","Driver not found.");
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return con;
//    }

