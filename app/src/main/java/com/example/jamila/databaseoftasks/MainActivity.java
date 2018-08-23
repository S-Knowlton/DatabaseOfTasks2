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

    private DBHandler dbHandler;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_idea);
        dbHandler = new DBHandler(this);
        items = new ArrayList<String>();
        lv = (ListView)findViewById(R.id.task_viewer);
        //adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, items);
        //lv.setAdapter(adapter);
        updateTasks();
        Log.d("Insert", "Inserting ..");
    }

    public void onClickCreate(View view){
        //TODO Clean
        //Button create = (Button)findViewById(R.id.create);
        int id = dbHandler.getTaskCount();
        if(id != 0) {
            id = (dbHandler.getAllTasks().get(id).getId()) + 1;
        }
        Task t = new Task(id, "Task " + id);
        dbHandler.addTask(t);
        Intent send = new Intent(MainActivity.this, TaskActivity.class);
        send.putExtra("id", id);
        startActivity(send);
    }

    private void updateTasks(){
        List<Task> taskList =  dbHandler.getAllTasks();
        items.clear();
        for(int i = 0; i < dbHandler.getTaskCount(); i++){
            Task temp = taskList.get(i);
            String s = temp.isCompleted() ? "; Complete" : "; Incomplete";
            items.add(temp.getName() + "; Time spent: " + temp.getCurrentTotal() + s);
        }
        for(Task t : dbHandler.getAllTasks()){
            final Button btnShow = new Button(this);
            String s = t.getName();//TODO Re-add  + "; Time spent: " + t.getCurrentTotal() +(t.isCompleted() ? "; Complete" : "; Incomplete");
            items.add(s);
            btnShow.setText(s);
            btnShow.setPadding(60,20,60,20);
            ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0,20,0,20);
            btnShow.setLayoutParams(lp);
            btnShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent send = new Intent(MainActivity.this, TaskActivity.class);
                    send.putExtra("id", items.indexOf(btnShow.getText()));
                    startActivity(send);
                }
            });
            lv.addView(btnShow);
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
}
