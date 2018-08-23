package com.example.jamila.databaseoftasks;

import java.util.Timer;
import java.util.TimerTask;

public class Task {
    private int id;
    private String name;
    private long currentTotal;
    private boolean completed;
//    private Timer timer;//TODO Clean

    //This constructor is used by the DBHandler
    public Task(){}

    //This constructor is used by - DBHandler:getTask(), MainActivity: onClickCreate()
    public Task(int id, String name){

        this.name = name;
        this.id = id;
        currentTotal = 0;
        completed = false;
//        timer = new Timer();//TODO Clean
    }

    //This constructor is for loading up saved tasks
    public Task(int id, String name, long currentTotal, boolean completed){
        //TODO use this
        this.name = name;
        this.id = id;
        this.currentTotal = currentTotal;
        this.completed = completed;
//        timer = new Timer();//TODO Clean
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCurrentTotal() {
        return currentTotal;
    }

    public void setCurrentTotal(long currentTotal) {
        this.currentTotal = currentTotal;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    //TODO Clean
//    public void startTimer(){
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                currentTotal++;
//            }
//        }, 0, 1000);
//    }
//
//    public void stopTimer(){
//        timer.cancel();
//    }
}
