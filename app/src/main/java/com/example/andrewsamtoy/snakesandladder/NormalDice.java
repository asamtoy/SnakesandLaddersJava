package com.example.andrewsamtoy.snakesandladder;

import java.util.Random;

/**
 * Created by andrewsamtoy on 9/13/17.
 */

public class NormalDice implements Dice {
    private Random random = new Random();
    private int numberOfSides;

    public NormalDice(int numberOfSides){
        this.numberOfSides = numberOfSides;
    }


    @Override
    public int roll() {
        return random.nextInt() + 1;
    }
}
