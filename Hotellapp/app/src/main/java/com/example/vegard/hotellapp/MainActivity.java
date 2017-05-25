package com.example.vegard.hotellapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private HotellApp hotell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HotellApp.getInstance();

        hotell = HotellApp.getInstance();

        ((TextView)findViewById(R.id.username)).setText(hotell.getUsername());
    }
}
