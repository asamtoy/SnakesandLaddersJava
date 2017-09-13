package com.example.andrewsamtoy.snakesandladder;

/**
 * Created by andrewsamtoy on 9/13/17.
 */

public class Player {
    private String name;
    private int position;

    public Player(String name){
        this.name = name;
        this.position = 0;

    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int diceResult){
        int currentPosition = this.position;
        this.setPosition(currentPosition + diceResult);
    }

}
