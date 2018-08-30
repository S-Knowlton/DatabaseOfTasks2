package com.example.jamila.databaseoftasks;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
//TODO Clean
//import android.widget.AdapterView;
//import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

   // private DBHandler dbHandler;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_idea);

    }

    public void onClickCreate(View view){
        //TODO Clean
        //Button create = (Button)findViewById(R.id.create);

    }

    private void updateTasks(){

        }
    }

    //TODO Clean
//    public void onClickDelete(){
//        Button create = (Button)findViewById(R.id.create);
//        Task t = new Task(dbHandler.getTaskCount(), "Temp");
//        dbHandler.deleteTask(t);
//    }
//    public void onClickUpdate(){
//        Button create = (Button)findViewById(R.id.create);
//        Task t = new Task(dbHandler.getTaskCount(), "Temp");
//        dbHandler.updateTask(t);
//    }
//    public void onClickRead(){
//        Button create = (Button)findViewById(R.id.create);
//        dbHandler.getTask(0);
//    }

