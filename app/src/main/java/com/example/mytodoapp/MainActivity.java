package com.example.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button bttnadd;
    private ListView listView;
    private TextView count;

    Context context;
    private DB_Handler dbHandler;

    private List<ToDoModel> toDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        dbHandler = new DB_Handler(this);



        bttnadd = findViewById(R.id.add);
        listView = findViewById(R.id.todoList);
        count = findViewById(R.id.todocount);

        toDos = new ArrayList<>();

        toDos =  dbHandler.getAllToDos();

        TodoAdapter adapter = new TodoAdapter(context,R.layout.singlerow,toDos);

        listView.setAdapter(adapter);

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