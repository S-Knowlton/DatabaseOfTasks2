package com.example.jamila.databaseoftasks;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASENAME = "tasks.db";
    private static final String TABLENAME = "tasks";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";


    public DBHandler(Context context){
        super(context,DATABASENAME,null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLENAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + "TEXT"
                 +")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLENAME);
        onCreate(db);
    }

    public void addTasks(Tasks tasks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, tasks.getName());

        db.insert(TABLENAME, null, values);
        db.close();
    }

    public Tasks getTasks(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLENAME, new String[]{KEY_ID, KEY_NAME}, KEY_ID + "=?",
                new String[] {String.valueOf(id) }, null, null, null,null);
        if(cursor != null)
            cursor.moveToFirst();
        Tasks tasks = new Tasks(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));
        return tasks;
    }

    public List<Tasks> getAllTasks() {
        List<Tasks> tasks = new ArrayList<Tasks>();
        String selectQuery = "SELECT * FROM " + TABLENAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Tasks task = new Tasks();
                task.setId(Integer.parseInt(cursor.getString(0)));
                task.setName(cursor.getString(2));
                tasks.add(task);
            } while (cursor.moveToNext());
        }
            return tasks;
    }

    public int getTaskCount(){

        String countQuery = "SELECT * FROM " + TABLENAME;
        SQLiteDatabase db =  this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();

    }

    public int updateTasks(Tasks tasks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, tasks.getName());

        return db.update(TABLENAME, values, KEY_ID + " = ?",
                new String[]{String.valueOf(tasks.getId())});
    }

    public void deleteTask(Tasks tasks){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLENAME, KEY_ID + " = ?",
                new String[]{String.valueOf(tasks.getId())});
        db.close();
    }
}
