package com.example.mytodoapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB_Handler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_Name = "todo";
    private static final String Table_Name = "todo";

    //Column names
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String STARTED = "started";
    private static final String FINISHED = "finished";

    public DB_Handler(@Nullable Context context) {
        super(context, DB_Name, null,  VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String TABLE_CREATE_QUARY = "CREATE TABLE "+Table_Name+" "+
                "("
                +ID+ "INTEGER PRIMARY KEY AUTOINCREMENT,"
                +TITLE+ "TEXT,"
                +DESCRIPTION+ "TEXT,"
                +STARTED+ "TEXT,"
                +FINISHED+ "TEXT"+
                ");";


        sqLiteDatabase.execSQL(TABLE_CREATE_QUARY);

        /* CREATE TABLE todo (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT , description TEXT, started TEXT, finished TEXT); */

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+Table_Name;
        //Drop older table if existed
        sqLiteDatabase.execSQL(DROP_TABLE_QUERY);
        //Create table again
        onCreate(sqLiteDatabase);
    }
}
