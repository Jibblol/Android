package com.example.vegard.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartScreen extends AppCompatActivity implements View.OnClickListener{

    private Button startBtn;
    private TicTacToe ticTacToe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        startBtn = (Button) findViewById(R.id.startBtn);
        startBtn.setOnClickListener(this);
        ticTacToe = TicTacToe.getInstance();
    }

    @Override
    public void onClick(View v) {
        EditText p1 = (EditText) findViewById(R.id.player1);
        EditText p2 = (EditText) findViewById(R.id.player2);
        ticTacToe.newGame(p1.getText().toString(), p2.getText().toString());
        startActivity(new Intent(StartScreen.this, BoardActivity.class));
    }
}
