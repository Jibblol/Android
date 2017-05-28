package com.example.vegard.hotellapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vegard.hotellapp.HotellApp;
import com.example.vegard.hotellapp.R;
import com.example.vegard.hotellapp.User;
import com.example.vegard.hotellapp.db.DBHelper;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBtn;
    private HotellApp hotell;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);
        hotell = HotellApp.getInstance();
        db = new DBHelper(LoginActivity.this, null, null, 1);
    }

    @Override
    public void onClick(View v){
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);

        User user = db.getUser(username.getText().toString());
        if (user == null) {
            // fant ikke brukernavn
            Toast.makeText(LoginActivity.this, "User does not exist", Toast.LENGTH_LONG).show();
            return;
        }

        if (!user.getPassword().equals(password.getText().toString())) {
            // feil passord
            Toast.makeText(LoginActivity.this, "Wrong password", Toast.LENGTH_LONG).show();
            return;
        }

        hotell.setUser(user);

        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}
