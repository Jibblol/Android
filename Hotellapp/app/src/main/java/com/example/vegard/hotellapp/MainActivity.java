package com.example.vegard.hotellapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private HotellApp hotell;
    private Button roomServiceBtn, lateArrivalBtn, mapBtn, myBookingsBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HotellApp.getInstance();

        hotell = HotellApp.getInstance();

        ((TextView)findViewById(R.id.username)).setText(hotell.getUsername());

        roomServiceBtn = (Button) findViewById(R.id.roomServiceBtn);
        roomServiceBtn.setOnClickListener(this);

        lateArrivalBtn = (Button) findViewById(R.id.lateArrivalBtn);
        lateArrivalBtn.setOnClickListener(this);

        mapBtn = (Button) findViewById(R.id.mapBtn);
        mapBtn.setOnClickListener(this);

        myBookingsBtn = (Button) findViewById(R.id.myBookingsBtn);
        myBookingsBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == roomServiceBtn) {
            startActivity(new Intent(MainActivity.this, RoomServiceActivity.class));
        } else if (v == lateArrivalBtn){
            startActivity(new Intent(MainActivity.this, LateArrivalActivity.class));
        } else if (v == mapBtn){
            startActivity(new Intent(MainActivity.this, MapActivity.class));
        } else if (v == myBookingsBtn){
            startActivity(new Intent(MainActivity.this, BookingsActivity.class));
        }
    }
}
