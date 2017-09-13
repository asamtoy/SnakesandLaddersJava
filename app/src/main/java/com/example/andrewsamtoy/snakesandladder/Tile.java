package com.example.andrewsamtoy.snakesandladder;

/**
 * Created by andrewsamtoy on 9/13/17.
 */

public class Tile {

    int movePlayerBy;

    public Tile(int movePlayerBy){
        this.movePlayerBy = movePlayerBy;
    }

    public int getMovePlayerBy(){
        return this.movePlayerBy;
    }


}
