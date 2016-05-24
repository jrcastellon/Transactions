package com.jorgecastellonjr.transactions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Transactions extends AppCompatActivity {

    //Variable declarations
    Intent intent;
    ListView listView;
    ArrayAdapter adapter;
    ArrayList<CustomObject> list;
    CustomObject data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        //making the list view adjustments
        listView = (ListView) findViewById(R.id.listView);
        adapter = new CustomAdapter(this, R.layout.layout_row,MainActivity.list);
        listView.setAdapter(adapter);

        //incase a toast is wanted
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int currentItem, long id) {
            }
        });*/
    }



    public void clickAdd(View view){
        //method onClick for add transactions page
        intent = new Intent(this,AddTransactions.class);
        startActivity(intent);
        finish();
    }
}
