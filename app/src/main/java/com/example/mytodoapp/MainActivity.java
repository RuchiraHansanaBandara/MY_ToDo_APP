package com.example.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button bttnadd;
    private ListView listView;
    private TextView count;

    private DB_Handler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new DB_Handler(this);



        bttnadd = findViewById(R.id.add);
        listView = findViewById(R.id.todoList);
        count = findViewById(R.id.todocount);

        // get todo count from table

        int countToDo = dbHandler.countToDo();
        count.setText("You Have "+countToDo+" todos");

        bttnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AddTodo.class);
                startActivity(i);
            }
        });
    }
}