package com.example.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddTodo extends AppCompatActivity {

    EditText addTitle,addDesc;
    Button addTodo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        addTitle = findViewById(R.id.addTitle);
        addDesc = findViewById(R.id.addDescription);
        addTodo = findViewById(R.id.buttonadd);
    }
}