package com.example.jamila.databaseoftasks;

public class Tasks {
    private int id;
    private String name;



    public Tasks(){

    }
    public Tasks(int id, String name){

        this.name = name;
        this.id = id;

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


}
