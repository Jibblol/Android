package com.example.vegard.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import static com.example.vegard.tictactoe.R.id.cell1;

public class BoardActivity extends AppCompatActivity implements View.OnClickListener{

    private TicTacToe ticTacToe;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        TicTacToe.getInstance();

        ticTacToe = TicTacToe.getInstance();
        updateBoard(ticTacToe.getBoard());

        ((TextView)findViewById(R.id.player1)).setText(ticTacToe.getPlayername1());
        ((TextView)findViewById(R.id.player2)).setText(ticTacToe.getPlayername2());

        ((TextView)findViewById(R.id.active)).setText(ticTacToe.getActivePlayer().getPlayername());

        findViewById(R.id.restart).setOnClickListener(this);
        findViewById(R.id.newGame).setOnClickListener(this);

        findViewById(R.id.cell0).setOnClickListener(this);
        findViewById(R.id.cell1).setOnClickListener(this);
        findViewById(R.id.cell2).setOnClickListener(this);
        findViewById(R.id.cell3).setOnClickListener(this);
        findViewById(R.id.cell4).setOnClickListener(this);
        findViewById(R.id.cell5).setOnClickListener(this);
        findViewById(R.id.cell6).setOnClickListener(this);
        findViewById(R.id.cell7).setOnClickListener(this);
        findViewById(R.id.cell8).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Button btn = (Button)v;
        switch (btn.getId()){
            case R.id.restart:
                ticTacToe.reset();
                updateBoard(ticTacToe.getBoard());
                break;
            case R.id.newGame:
                startActivity(new Intent(BoardActivity.this, StartScreen.class));
                break;
            default:
                boardClick(btn);
                break;
        }

    }

    private void boardClick(Button btn) {
        String text = btn.getText().toString();
        if (text.isEmpty()) {
            int index = 0;
            switch (btn.getId()) {
                case R.id.cell0:
                    index = 0; break;
                case R.id.cell1:
                    index = 1; break;
                case R.id.cell2:
                    index = 2; break;
                case R.id.cell3:
                    index = 3; break;
                case R.id.cell4:
                    index = 4; break;
                case R.id.cell5:
                    index = 5; break;
                case R.id.cell6:
                    index = 6; break;
                case R.id.cell7:
                    index = 7; break;
                case R.id.cell8:
                    index = 8; break;
            }
            ticTacToe.markCell(index);
            updateBoard(ticTacToe.getBoard());
        }

        if (ticTacToe.isWinner()) {
            // score and end game
            ((TextView)findViewById(R.id.active)).setText(ticTacToe.getActivePlayer().getPlayername() + " Wins!");
        } else {
            ticTacToe.switchPlayer();
            ((TextView)findViewById(R.id.active)).setText(ticTacToe.getActivePlayer().getPlayername());
        }
    }

    private void updateBoard(List<String> board) {
        ((Button)findViewById(R.id.cell0)).setText(board.get(0));
        ((Button)findViewById(R.id.cell1)).setText(board.get(1));
        ((Button)findViewById(R.id.cell2)).setText(board.get(2));
        ((Button)findViewById(R.id.cell3)).setText(board.get(3));
        ((Button)findViewById(R.id.cell4)).setText(board.get(4));
        ((Button)findViewById(R.id.cell5)).setText(board.get(5));
        ((Button)findViewById(R.id.cell6)).setText(board.get(6));
        ((Button)findViewById(R.id.cell7)).setText(board.get(7));
        ((Button)findViewById(R.id.cell8)).setText(board.get(8));
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
