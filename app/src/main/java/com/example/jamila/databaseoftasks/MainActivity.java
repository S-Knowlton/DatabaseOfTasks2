package com.example.jamila.databaseoftasks;

import android.app.Fragment;
import android.content.Intent;
import android.nfc.Tag;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
//TODO Clean
//import android.widget.AdapterView;
//import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

   // private DBHandler dbHandler;
   private DatabaseReference mDatabase;
   private int lastID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_idea);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        lastID = 0;
    }

    public void addTask(){
        Task task = new Task();
        CustomAdapter adapter = new CustomAdapter();
        task.setId(adapter.getCount());
        String name = task.getName();
        long getTotal = task.getCurrentTotal();
        boolean isComplete = task.isCompleted();

        Task tasks = new Task(adapter.getCount(), name, getTotal, isComplete);
        mDatabase.child(adapter.getCount() + " ").setValue(tasks);

    }

    public void onClickCreate(View view){
        //TODO Clean
        Button create = (Button)findViewById(R.id.create);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAdapter adapter = new CustomAdapter();
                Intent send = new Intent(MainActivity.this, TaskActivity.class);
                send.putExtra("id", adapter.getCount());
                startActivity(send);
                addTask();
            }
        });

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

