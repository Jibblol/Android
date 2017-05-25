package com.example.vegard.tictactoe;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Vegard on 10.05.2017.
 */

public class TicTacToe {

    private static TicTacToe ticTacToe;
    private Player player1;
    private Player player2;
    private Player activePlayer;

    private List<String> board;

    public void reset() {
        activePlayer = player1;
        board = Arrays.asList("","","","","","","","","");
    }

    public void newGame(String playername1, String playername2) {
        player1 = new Player("X", playername1);
        player2 = new Player("O", playername2);
        reset();
    }

    public static TicTacToe getInstance(){
        if(ticTacToe == null) ticTacToe = new TicTacToe();
        return ticTacToe;
    }

    public String getPlayername1() {
        return player1.getPlayername();
    }

    public String getPlayername2() {
        return player2.getPlayername();
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void markCell(int index) {
        board.set(index, activePlayer.getSymbol());
    }

    public boolean isWinner() {
        String symbol = activePlayer.getSymbol();

        if (
            // Horizontal lines
            board.get(0).equals(symbol) && board.get(1).equals(symbol) && board.get(2).equals(symbol) ||
            board.get(3).equals(symbol) && board.get(4).equals(symbol) && board.get(5).equals(symbol) ||
            board.get(6).equals(symbol) && board.get(7).equals(symbol) && board.get(8).equals(symbol) ||

            // Vertical lines
            board.get(0).equals(symbol) && board.get(3).equals(symbol) && board.get(6).equals(symbol) ||
            board.get(1).equals(symbol) && board.get(4).equals(symbol) && board.get(7).equals(symbol) ||
            board.get(2).equals(symbol) && board.get(5).equals(symbol) && board.get(8).equals(symbol) ||

            // Diagonal lines
            board.get(0).equals(symbol) && board.get(4).equals(symbol) && board.get(8).equals(symbol) ||
            board.get(2).equals(symbol) && board.get(4).equals(symbol) && board.get(6).equals(symbol)){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        int n = 0;
        for (String s : board) {
            if (!s.isEmpty()) {
                n++;
            }
        }
        return n == 9;
    }

    public void switchPlayer() {
        if (activePlayer == player1){
            activePlayer = player2;
        } else{
            activePlayer = player1;
        }
    }

    public List<String> getBoard() {
        return board;
    }
}
