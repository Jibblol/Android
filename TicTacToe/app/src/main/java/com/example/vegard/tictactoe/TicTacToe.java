package com.example.vegard.tictactoe;

/**
 * Created by Vegard on 10.05.2017.
 */

public class TicTacToe {

    private static TicTacToe ticTacToe;
    private String playername1;
    private String playername2;

    public static TicTacToe getInstance(){
        if(ticTacToe == null) ticTacToe = new TicTacToe();
        return ticTacToe;
    }

    public String getPlayername1() {
        return playername1;
    }

    public void setPlayername1(String playername1) {
        this.playername1 = playername1;
    }

    public String getPlayername2() {
        return playername2;
    }

    public void setPlayername2(String playername2) {
        this.playername2 = playername2;
    }
}
