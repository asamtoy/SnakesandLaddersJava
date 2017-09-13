package com.example.andrewsamtoy.snakesandladder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created by andrewsamtoy on 9/13/17.
 */

public class GameTest {

    Game game;
    Board board;
    ArrayList<Player> players;
    Dice spyDice;
    Player player1, player2;
    Board shortBoard;
    Game shortGame;

    @Before
    public void before(){
        board = new Board(40);
        board.addSpecialTile(3, 5);
        board.addSpecialTile(6, -4);
        board.addSpecialTile(10, 2);
        players = new ArrayList<>();
        player1 = new Player("Raul");
        player2 = new Player("Andrew");
        players.add(player1);
        players.add(player2);
        Dice dice = new NormalDice(6);
        spyDice = Mockito.spy(dice);
        game = new Game(spyDice, board, players);
        shortBoard = new Board(3);
        shortGame = new Game(spyDice, shortBoard, players);
    }

    @Test
    public void TestGameAfterFirstRound(){
        Mockito.when(spyDice.roll()).thenReturn(2);
        game.playRound();

        assertEquals(0, player2.getPosition());
        assertEquals(2, player1.getPosition());
        assertEquals(player2, game.getCurrentPlayer());
    }
    @Test
    public void TestGameAfterFirstRoundLadderHit(){
        Mockito.when(spyDice.roll()).thenReturn(3);
        game.playRound();

        assertEquals(0, player2.getPosition());
        assertEquals(8, player1.getPosition());
        assertEquals(player2, game.getCurrentPlayer());
    }

    @Test
    public void TestGameAfterFirstRoundSnakeHit(){
        Mockito.when(spyDice.roll()).thenReturn(6);
        game.playRound();

        assertEquals(0, player2.getPosition());
        assertEquals(2, player1.getPosition());
        assertEquals(player2, game.getCurrentPlayer());
    }

    @Test
    public void TestGameAfterSecondRound(){
        Mockito.when(spyDice.roll()).thenReturn(6).thenReturn(4);
        game.playRound();
        game.playRound();
        assertEquals(2, player1.getPosition());
        assertEquals(4, player2.getPosition());
        assertEquals(player1, game.getCurrentPlayer());

    }

    @Test
    public void TestPlayerCanWin(){
        Mockito.when(spyDice.roll()).thenReturn(3);
        shortGame.playRound();
        assertEquals(player1, shortGame.getWinner());
    }

    @Test
    public void TestGameAfterThirdRound(){
        Mockito.when(spyDice.roll()).thenReturn(6).thenReturn(4).thenReturn(3);
        game.playRound();
        game.playRound();
        game.playRound();
        assertEquals(5, player1.getPosition());
        assertEquals(4, player2.getPosition());
        assertEquals(player2, game.getCurrentPlayer());
    }

    @Test
    public void TestGameRun(){
        Mockito.when(spyDice.roll()).thenReturn(1).thenReturn(3).thenReturn(2);
        shortGame.playGame();
        assertEquals(player2, shortGame.getWinner());
        assertEquals(1, player1.getPosition());
    }
}
