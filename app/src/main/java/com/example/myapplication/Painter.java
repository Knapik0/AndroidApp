package com.example.myapplication;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.Spinner;

public class Painter {
    private String name;
    boolean toDelete;
    Drawable image;

    public Painter(String name, Drawable image) {
        this.name = name;
        this.toDelete = false;
        this.image = image;

    }

    public String getName() {
        return name;
    }
}
