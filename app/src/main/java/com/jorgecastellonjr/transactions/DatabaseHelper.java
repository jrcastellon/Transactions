package com.jorgecastellonjr.transactions;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by jorgecastellonjr. on 5/10/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "peopleDB";
    private static final String TABLE_NAME = "people";
    private static final int DATABASE_VERSION = 1;
    private static final String ID = "_id";
    private static final String NAME = "name";
    private static final String CATEGORY = "category";
    private static final String AMOUNT = "amount";
    private static final String DATE = "date";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME + " TEXT, "
            + CATEGORY + " TEXT, "
            + AMOUNT + " INTEGER, "
            + DATE + " INTEGER"
            + ");";

    private Context context;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        Log.i(MainActivity.TAG, "Database onCreate for the helper");
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
    }

    public void addObjects(CustomObject object){
        ContentValues values = new ContentValues();
        values.put(NAME, object.getName());
        values.put(CATEGORY, object.getCategory());
        values.put(AMOUNT, object.getAmount());
        values.put(DATE, object.getDate());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
        Log.i(MainActivity.TAG, "record inserted into database");
    }

    public ArrayList<CustomObject> getObject(){
        ArrayList<CustomObject> objects = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME + ";";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            CustomObject object = new CustomObject();
            object.setName(cursor.getString(1));
            object.setCategory(cursor.getString(2));
            object.setAmount(cursor.getString(3));
            object.setDate(cursor.getString(4));

            objects.add(object);
            cursor.moveToNext();
        }

        cursor.close();
        db.close();

        return objects;
    }

    public void removeObjects(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_NAME, ID + "=" + id, null);
        if(result > 0){
            Log.i(MainActivity.TAG, result + " rows removed");
        }
        db.close();
    }

    public void deleteData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
    }
}
