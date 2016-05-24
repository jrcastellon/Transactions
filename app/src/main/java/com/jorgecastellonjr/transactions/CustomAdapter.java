package com.jorgecastellonjr.transactions;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jorgecastellonjr. on 4/19/16.
 */
public class CustomAdapter extends ArrayAdapter<CustomObject>{
    Context context;
    int layoutResourceId;
    ArrayList<CustomObject> data = null;

    public CustomAdapter(Context context, int layoutResourceId, ArrayList<CustomObject> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        CustomObjectHolder holder = null;
        if (row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId,parent,false);

            holder = new CustomObjectHolder();
            holder.textEntry = (TextView) row.findViewById(R.id.txtRowName);
            holder.textAmount = (TextView) row.findViewById(R.id.txtRowAmount);
            holder.textType = (TextView) row.findViewById(R.id.txtRowType);
            holder.textDate = (TextView) row.findViewById(R.id.txtRowDate);

            row.setTag(holder);
        }else{
            holder = (CustomObjectHolder) row.getTag();
        }

        CustomObject object = data.get(position);
        holder.textEntry.setText(object.getName());
        holder.textAmount.setText(object.getAmount());
        holder.textType.setText(object.getCategory());
        holder.textDate.setText(object.getDate());
        return row;
    }

    static class CustomObjectHolder{
        TextView textEntry;
        TextView textAmount;
        TextView textType;
        TextView textDate;
    }
}
