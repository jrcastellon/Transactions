package com.jorgecastellonjr.transactions;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddTransactions extends AppCompatActivity {

    //Variable declaration
    Intent intent;
    EditText edtName;
    EditText edtCategory;
    EditText edtAmount;
    EditText edtDate;
    String name;
    String category;
    String amount;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transactions);

        //identifying all the text editable
        edtName = (EditText) findViewById(R.id.edName);
        edtCategory = (EditText) findViewById(R.id.edCategory);
        edtAmount = (EditText) findViewById(R.id.edAmount);
        edtDate = (EditText) findViewById(R.id.edDate);
        Log.i("test3", MainActivity.list.size() + "");
    }

    public void clickCancel(View view){
        //closing the page
        finish();
    }

    public void clickSubmit(View view){

        //creating variables to editable texts
        name = edtName.getText().toString();
        category = edtCategory.getText().toString();
        amount = edtAmount.getText().toString();
        date = edtDate.getText().toString();

        //grabing the database to write to it
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        //adding the editable texts to database
        databaseHelper.addObjects(new CustomObject(name, category, amount, date));

        //go to main activity
        intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
