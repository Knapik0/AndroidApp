package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Painter> data;
    private PainterAdapter adapter;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.list);
        Button button = findViewById(R.id.button);
        data = new ArrayList<>();
        data.add(new Painter("Claude Monet", getDrawable(R.drawable.monet)));
        data.add(new Painter("Pablo Picasso", getDrawable(R.drawable.picasso)));
        data.add(new Painter("Jan Matejko", getDrawable(R.drawable.matejko)));
        data.add(new Painter("Edvard Munch", getDrawable(R.drawable.munch)));
        data.add(new Painter("Rembrandt", getDrawable(R.drawable.rembrandt)));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Painter> paintersToDelete = new ArrayList<>();
                for(Painter painter : data){
                    if (painter.toDelete) {
                        paintersToDelete.add(painter);
                    }
                }
                data.removeAll(paintersToDelete);
                adapter.notifyDataSetChanged();
            }
        });
        adapter = new PainterAdapter(this, data);
        listView.setAdapter(adapter);
    }
}