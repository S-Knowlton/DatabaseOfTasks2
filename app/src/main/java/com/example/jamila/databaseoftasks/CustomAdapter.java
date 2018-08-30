package com.example.jamila.databaseoftasks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter{
    Button CreateTask;

    Context context;

    ArrayList<Task> task;

    LayoutInflater inflater;

    public CustomAdapter(Context context, ArrayList<Task> task) {
        this.context = context;
        this.task = task;
    }

    @Override
    public int getCount() {
        return task.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.from(context).inflate(R.layout.task_view,viewGroup,false);



        CreateTask = (Button) view.findViewById(R.id.create);


        return view;
    }
}
