package com.example.mytodoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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
    public void onCreate(SQLiteDatabase db) {


        String TABLE_CREATE_QUERY = "CREATE TABLE "+Table_Name+" " +
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +TITLE + " TEXT, "
                +DESCRIPTION + " TEXT, "
                +STARTED+ " TEXT, "
                +FINISHED+ " TEXT" +
                ");";


        db.execSQL(TABLE_CREATE_QUERY);

        // CREATE TABLE todo (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT , description TEXT, started TEXT, finished TEXT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ Table_Name;
        //Drop older table if existed
        db.execSQL(DROP_TABLE_QUERY);
        //Create table again
        onCreate(db);
    }
    public void addTodo(ToDoModel toDo){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();


        ContentValues contentValues = new ContentValues();

        contentValues.put(TITLE,toDo.getTitle());
        contentValues.put(DESCRIPTION,toDo.getDescription());
        contentValues.put(STARTED,toDo.getStarted());
        contentValues.put(FINISHED,toDo.getFinished());


        //Save to table
        sqLiteDatabase.insert(Table_Name,null,contentValues);
        sqLiteDatabase.close();
    }
    public int countToDo(){
        SQLiteDatabase db = getReadableDatabase();
        String queary = "SELECT * FROM "+ Table_Name;

        Cursor cursor = db.rawQuery(queary,null);
        return cursor.getCount();
    }

    //get all todos into a list

    public List<ToDoModel> getAllToDos(){

        List<ToDoModel> toDos = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String Query = "SELECT * FROM "+Table_Name;

        Cursor cursor = db.rawQuery(Query,null);

        if(cursor.moveToFirst()){
            do {
                //create a todo object

                ToDoModel toDoModel = new ToDoModel();

                toDoModel.setId(cursor.getInt(0));
                toDoModel.setTitle(cursor.getString(1));
                toDoModel.setDescription(cursor.getString(2));
                toDoModel.setStarted(cursor.getLong(3));
                toDoModel.setFinished(cursor.getLong(4));

                toDos.add(toDoModel);


            }while (cursor.moveToNext());

        }
        return toDos;
    }
}
