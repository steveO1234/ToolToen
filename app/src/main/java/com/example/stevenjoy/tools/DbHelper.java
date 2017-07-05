//package com.example.stevenjoy.tools;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.support.annotation.Nullable;
//
///**
// * Created by stevenjoy on 7/1/17.
// */
//
//public class DbHelper extends SQLiteOpenHelper {
//
//    private final Context context;
//
//
//    public static final String DATABASE_NAME = "users.db";
//    public static final String TABLE_NAME = "users";
//    public static final String COL_0 = "ID";
//    public static final String COL_1 = "Fname";
//    public static final String COL_2 = "Lname";
//    public static final String COL_3 = "Age";
//    public static final String COL_4 = "Address";
//    public static final String COL_5 = "City";
//    public static final String COL_6 = "State";
//    public static final String COL_7 = "Email";
//    public static final String COL_8 = "Password";
//    public static final String COL_9 = "Phone";
//
//    public DbHelper(Context context) {
//        super(context, DATABASE_NAME, null, 1);
//
//        this.context=context;
//       // SQLiteDatabase db = this.getWritableDatabase();
//
//    }
//
////    private static final String dataCreate = ("create table "adb shell + DATABASE_NAME+ "
// //     (ID INTEGER PRIMARY KEY AUTOINCREMENT,)" + " ("+COL_1+")" +" ("+COL_2+")" +" ("+COL_3+")" +" ("+COL_4+")"
// //           +" ("+COL_5+")"+" ("+COL_6+")"+" ("+COL_7+")"+" ("+COL_8+")"+" ("+COL_9+")");
//
//    private static final String dataCreate = ("create table " + DATABASE_NAME+
//            "(ID INTEGER PRIMARY KEY AUTOINCREMENT,Fname TEXT,Lname TEXT,Age INTEGER,Address TEXT,City TEXT,State" +
//             " TEXT,Email TEXT,Password Integer,Phone Integer)");
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//
//        db.execSQL("CREATE TABLE "+ DATABASE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +  COL_1 +
//        " TEXT NOT NULL, " + COL_2 + " TEXT NOT NULL, " + COL_3 + " INTEGER NOT NULL, " +COL_4 + " TEXT NOT NULL, "
//                +COL_5 + " TEXT NOT NULL, " +COL_6 + " TEXT NOT NULL, " +COL_7 + " TEXT NOT NULL, "+ COL_8 + " INTEGER NOT NULL,"
//                + COL_9 + " INTEGER NOT NULL,");
//    }
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
//    }
//}
