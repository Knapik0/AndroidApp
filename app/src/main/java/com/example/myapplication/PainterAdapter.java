package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.json.JSONArray;

import java.util.ArrayList;

public class PainterAdapter extends ArrayAdapter<Painter> {
    private ArrayList<Painter> data;
    private Context context;

    public PainterAdapter(@NonNull Context context, ArrayList<Painter> data) {
        super(context, R.layout.item_layout, data);
        this.data = data;
        this.context = context;
    }


    @NonNull
    public View getView(final int position, View convertView, @NonNull ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.item_layout, parent, false);

        final TextView name = rowView.findViewById(R.id.painterName);

        name.setText(data.get(position).getName());

        final ImageView imageView = rowView.findViewById(R.id.image);
        imageView.setImageDrawable(data.get(position).image);

        final CheckBox checkBox = rowView.findViewById(R.id.checkBox);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.get(position).toDelete = checkBox.isChecked();
            }
        });

        return rowView;
    }
}
