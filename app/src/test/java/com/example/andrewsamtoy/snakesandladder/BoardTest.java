package com.example.andrewsamtoy.snakesandladder;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by andrewsamtoy on 9/13/17.
 */

public class BoardTest {

    Board board;

    @Before
    public void before(){
        board = new Board(40);

    }

    @Test
    public void testBoardHasWinningTile(){
        assertEquals(39, board.getWinningTile());
    }

    @Test
    public void testCanAddModifiers(){
        board.addSpecialTile(4, -2);
        assertEquals(-2, (int) board.returnModifier(4));
    }

}
