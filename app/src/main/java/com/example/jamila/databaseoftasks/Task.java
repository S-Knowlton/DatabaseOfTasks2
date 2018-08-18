package com.example.jamila.databaseoftasks;

import java.util.Timer;
import java.util.TimerTask;

public class Task {
    private int id;
    private String name;
    private Timer timer;
    private long currentTotal;
    private boolean completed;


    public Task(){

    }

    public Task(int id, String name){

        this.name = name;
        this.id = id;
        timer = new Timer();
        currentTotal = 0;
        completed = false;
    }

    public Task(int id, String name, long currentTotal){

        this.name = name;
        this.id = id;
        timer = new Timer();
        this.currentTotal = currentTotal;
        completed = false;
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

    public void startTimer(){
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                currentTotal++;
            }
        }, 0, 1000);
    }

    public void stopTimer(){
        timer.cancel();
    }

}
