package com.example.vegard.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Scoreboard extends AppCompatActivity {

    private TicTacToe ticTacToe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        ticTacToe = TicTacToe.getInstance();

        List<Map.Entry<String, Integer>> scoreEntriesAsList = new LinkedList<>(ticTacToe.getScores().entrySet());
        Collections.sort(scoreEntriesAsList, new ScoreEntryComparator());

        List<String> scores = new ArrayList<>();
        for(Map.Entry<String, Integer> score : scoreEntriesAsList){
            scores.add(score.getKey() + " - " + score.getValue() + " wins");
        }
        ArrayAdapter<String> listAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, scores);

        ((ListView)findViewById(R.id.scores)).setAdapter(listAdapter);


    }

    class ScoreEntryComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return Integer.compare(o2.getValue(), o1.getValue());
        }
    }
}
