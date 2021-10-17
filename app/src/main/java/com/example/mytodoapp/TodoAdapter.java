package com.example.mytodoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class TodoAdapter extends ArrayAdapter<ToDoModel> {

    private Context context;
    private int resource;
    List<ToDoModel> todos;

    public TodoAdapter(@NonNull Context context, int resource, List<ToDoModel> todos) {
        super(context, resource,todos);
        this.context = context;
        this.resource = resource;
        this.todos = todos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView title = row.findViewById(R.id.Title);
        TextView description = row.findViewById(R.id.description);
        ImageView imageView = row.findViewById(R.id.onGoing);


        ToDoModel toDo = todos.get(position);
        title.setText(toDo.getTitle());
        description.setText(toDo.getDescription());
        imageView.setVisibility(row.INVISIBLE);

        if (toDo.getFinished() > 0){
            imageView.setVisibility(View.VISIBLE);
        }

        return row;
    }
}
