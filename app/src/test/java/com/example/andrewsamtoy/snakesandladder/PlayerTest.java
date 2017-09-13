package com.example.andrewsamtoy.snakesandladder;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by andrewsamtoy on 9/13/17.
 */

public class PlayerTest {

    Player player;

    @Before
    public void before(){
        player = new Player("Raul");

    }

    @Test
    public void testPlayerStartPosition0(){
        assertEquals(0, player.getPosition());
    }

    @Test
    public void testPlayerName(){
        assertEquals("Raul", player.getName());
    }

    @Test
    public void testSetPlayerPosition(){
        player.setPosition(5);
        assertEquals(5, player.getPosition());
    }
}
