package com.example.andrewsamtoy.snakesandladder;

import java.util.ArrayList;

/**
 * Created by andrewsamtoy on 9/13/17.
 */

public class Game {
    Dice dice;
    Board board;
    ArrayList<Player> players;
    Player currentPlayer;
    Player winner;
    Boolean gameOn;

    public Player getWinner() {
        return winner;
    }

    public Game(Dice dice, Board board, ArrayList<Player> players){
        this.dice = dice;
        this.board = board;
        this.players = players;
        this.currentPlayer = this.players.get(0);
        this.winner = null;
        this.gameOn = true;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void playGame(){
        while (gameOn == true){
            playRound();
        }
    }

    public void playRound(){
            int diceResult = rollDice();
            movePlayer(diceResult);
            checkIfSpecialTile();

            if (checkIfCurrentPlayerwins()){
                gameOver();
            }
            nextPlayer();
    }

    private int rollDice(){
        return this.dice.roll();
    }

    private void movePlayer(int diceResult){
        int currentPosition = currentPlayer.getPosition();
        this.currentPlayer.setPosition(currentPosition + diceResult);
    }

    private void checkIfSpecialTile(){
        int currentPosition = currentPlayer.getPosition();
        if (board.returnModifier(currentPosition) != null){
            currentPlayer.setPosition(currentPosition + board.returnModifier(currentPosition));
            checkIfSpecialTile();
        }
    }

    private boolean checkIfCurrentPlayerwins(){
        if (currentPlayer.getPosition() >= board.getWinningTile()){
            winner = currentPlayer;
            gameOn = false;
            return true;
        }
        else{
            return false;
        }
    }

    private void nextPlayer(){
        int indexOfCurrentPlayer = players.indexOf(currentPlayer);
        if (indexOfCurrentPlayer == players.size() - 1){
            currentPlayer = players.get(0);
        } else {
            currentPlayer = players.get(indexOfCurrentPlayer + 1);
        }
    }

    private void gameOver(){
        System.out.println(currentPlayer.getName() + " wins!");
//        System.exit(0);
    }



/* While nobody has won (boolean)
Dice rolls *
Player moved  *
Player checks if it's a special tile *
If special tile, adjust *
If not special tile, Game checks if player has met or exceeded the winning tile
If player wins, boolean set to false, game over
If player does not win, move to next player and repeat
   */
}
