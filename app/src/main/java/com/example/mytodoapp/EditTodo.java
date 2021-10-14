package com.example.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EditTodo extends AppCompatActivity {

    Button btnedit;
    EditText editTitle;
    EditText editDecs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_todo);

        btnedit = findViewById(R.id.buttonedit);
        editTitle = findViewById(R.id.editTitle);
        editDecs = findViewById(R.id.editDescription);
    }
}