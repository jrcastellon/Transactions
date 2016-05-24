package com.jorgecastellonjr.transactions;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Variable declaration
    Intent intent;
    public static ArrayList<CustomObject> list;
    public static final String TAG = "DB_DEMO";
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //starting the database
        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        //making the list to database
        list = databaseHelper.getObject();
        for (int i = 0; i < list.size(); i++){
            Log.i(TAG,"ID: " + list.get(i).getId() + "   "
                    + "Name: " + list.get(i).getName() + "   "
                    + "Category: " + list.get(i).getCategory() + "   "
                    + "Amount: " + list.get(i).getAmount() + "   "
                    + "Date: " + list.get(i).getDate() + "   "
            );
        }
    }

    public void clickTrans (View view){
        //method onClick for Transactions page
        intent = new Intent(this,Transactions.class);
        startActivity(intent);
    }

    public void clickAddTrans (View view){
        //method onClick for Add Transactions page
        intent = new Intent(this,AddTransactions.class);
        startActivity(intent);
    }

    public void clickDelete (View view){
        //Delete database
        databaseHelper.deleteData();
    }
}
