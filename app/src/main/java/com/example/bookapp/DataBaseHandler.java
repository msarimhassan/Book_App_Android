package com.example.bookapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHandler extends SQLiteOpenHelper {

    Context context;
    static final int DB_VERSION = 1;
    static final String DB_NAME= "Books_DB";
    static final String TABLE_NAME="Books";
    static final String Query="CREATE TABLE " + TABLE_NAME +
            "(" +
            "bookid" + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "bookname" + " TEXT," +
            "bookimage" + " INTEGER" +
            ")";

    public DataBaseHandler(Context context)
    {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Query);
        Log.d("my result","Table is created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
