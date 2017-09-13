package com.example.andrewsamtoy.snakesandladder;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by andrewsamtoy on 9/13/17.
 */

public class DiceTest {

    Dice spyDice;

    @Before
    public void before(){
        Dice dice = new NormalDice(6);
        spyDice = Mockito.spy(dice);

    }

    @Test
    public void testDiceReturns(){
        Mockito.when(spyDice.roll()).thenReturn(2);
        assertEquals(2, spyDice.roll());
    }

}
