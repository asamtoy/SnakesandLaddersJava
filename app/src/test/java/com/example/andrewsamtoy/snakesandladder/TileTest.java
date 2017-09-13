package com.example.andrewsamtoy.snakesandladder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andrewsamtoy on 9/13/17.
 */
public class TileTest {

    Tile normalTile;
    Tile snake;
    Tile ladder;

    @Before
    public void before(){
        normalTile = new Tile(0);
        snake = new Tile(-6);
        ladder = new Tile(3);
    }
    @Test
    public void getMovePlayerBy() throws Exception {
        assertEquals(0, normalTile.getMovePlayerBy());
        assertEquals(-6, snake.getMovePlayerBy());
        assertEquals(3, ladder.getMovePlayerBy());
    }

}