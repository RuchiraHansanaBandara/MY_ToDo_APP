package com.example.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTodo extends AppCompatActivity {

    private EditText title, desc;
    private Button add;
    private DB_Handler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        title = findViewById(R.id.addTitle);
        desc = findViewById(R.id.addDescription);
        add = findViewById(R.id.buttonadd);
        context = this;



        dbHandler = new DB_Handler(context);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String userTitle = title.getText().toString();
                String userDecs = desc.getText().toString();

                long started = System.currentTimeMillis();

                ToDoModel todo = new ToDoModel(userTitle,userDecs,started,0);
                
                dbHandler.addTodo(todo);

                startActivity(new Intent(context,MainActivity.class));


            }
        });
    }
}