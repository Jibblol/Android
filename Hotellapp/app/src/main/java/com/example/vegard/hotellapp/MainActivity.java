package com.example.vegard.hotellapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private HotellApp hotell;
    private Button roomServiceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HotellApp.getInstance();

        hotell = HotellApp.getInstance();

        ((TextView)findViewById(R.id.username)).setText(hotell.getUsername());

        roomServiceBtn = (Button) findViewById(R.id.roomServiceBtn);
        roomServiceBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, RoomServiceActivity.class));
    }
}
