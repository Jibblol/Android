package com.example.vegard.hotellapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBtn;
    private HotellApp hotell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);
        hotell = HotellApp.getInstance();
    }

    @Override
    public void onClick(View v){
        EditText user = (EditText) findViewById(R.id.username);
        EditText pass = (EditText) findViewById(R.id.password);
        hotell.setUsername(user.getText().toString());
        hotell.setPassword(pass.getText().toString());
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}
