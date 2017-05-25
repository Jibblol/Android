package com.example.vegard.tictactoe;

/**
 * Created by Vegard on 25.05.2017.
 */

public class Player {

    private String playername;
    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public Player(String symbol, String name) {
        this.playername = name;
        this.symbol = symbol;
    }

    public String getPlayername() {
        return playername;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
