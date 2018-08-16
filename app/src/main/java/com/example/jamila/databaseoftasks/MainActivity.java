package com.example.jamila.databaseoftasks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHandler db = new DBHandler(this);

        Log.d("Insert", "Inserting ..");
    }

    public void createClick(){

        Button create = (Button)findViewById(R.id.create);

    }
}
