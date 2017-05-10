package com.example.vegard.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class BoardActivity extends AppCompatActivity {

    private TicTacToe ticTacToe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        TicTacToe.getInstance();

        ticTacToe = TicTacToe.getInstance();

        ((TextView)findViewById(R.id.player1)).setText(ticTacToe.getPlayername1());
        ((TextView)findViewById(R.id.player2)).setText(ticTacToe.getPlayername2());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(BoardActivity.this, Scoreboard.class));
        return true;
    }
}
