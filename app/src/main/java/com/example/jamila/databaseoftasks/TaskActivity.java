package com.example.jamila.databaseoftasks;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TaskActivity extends AppCompatActivity {
    private DBHandler dbHandler;
    private Task task;
    private Timer timer;
    private long currentTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHandler dbHandler = new DBHandler(this);
        Intent i = getIntent();
        task = dbHandler.getTask(i.getIntExtra("id", 0));
        setup();
    }

    private void setup(){
        Button temp = (Button) findViewById(R.id.pause_timer_btn);
        temp.setEnabled(false);
        if(task.isCompleted()){
            temp = (Button) findViewById(R.id.start_timer_btn);
            temp.setEnabled(false);
            temp = (Button) findViewById(R.id.complete_btn);
            temp.setEnabled(false);
        }
        TextView title = (TextView) findViewById(R.id.title);
        title.setText(task.getName());
        TextView time = (TextView) findViewById(R.id.time);
        time.setText(task.getCurrentTotal() + "");
    }

    public void onClickDelete(View view){
        dbHandler.deleteTask(task);
        Intent send = new Intent(TaskActivity.this, MainActivity.class);
        startActivity(send);
    }

    public void onClickStart(View view){
        startTimer();
    }

    public void onClickPause(View view){
        stopTimer();
        task.setCurrentTotal(currentTotal);
        dbHandler.updateTask(task);
    }

    public void onClickComplete(View view){
        task.setCompleted(true);
        dbHandler.updateTask(task);
        Button temp = (Button) findViewById(R.id.pause_timer_btn);
        temp.setEnabled(false);
        temp = (Button) findViewById(R.id.start_timer_btn);
        temp.setEnabled(false);
        temp = (Button) findViewById(R.id.complete_btn);
        temp.setEnabled(false);
    }

    private void startTimer(){
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                currentTotal++;
                String s = getResources().getString(R.string.time);
                s += currentTotal;
                task.setCurrentTotal(currentTotal);
                dbHandler.updateTask(task);
            }
        }, 0, 1000);
    }

    private void stopTimer(){
        timer.cancel();
    }

}
