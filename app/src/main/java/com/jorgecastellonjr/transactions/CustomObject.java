package com.jorgecastellonjr.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by jorgecastellonjr. on 4/19/16.
 */
public class CustomObject implements Parcelable{
    private String name;
    private String category;
    private String amount;
    private String date;
    private String note;
    private Boolean income;
    private int id;

    public CustomObject() {
    }

    public CustomObject(Parcel in){
        name = in.readString();
        category = in.readString();
        amount = in.readString();
        date = in.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public CustomObject createFromParcel (Parcel in){
            return new CustomObject(in);
        }

        public CustomObject[] newArray(int size){
            return new CustomObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(category);
        dest.writeString(amount);
        dest.writeString(date);
    }

    public CustomObject(String name, String category, String amount, String date) {
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public CustomObject(String name, String category, String amount, String date, String note, Boolean income, int id) {
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.note = note;
        this.income = income;
        this.id = id;
    }

    public CustomObject(String name, String category, String amount, String date, String note, Boolean income) {
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.note = note;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getIncome() {
        return income;
    }

    public void setIncome(Boolean income) {
        this.income = income;
    }

    public int getId() {
        return id;
    }
}
