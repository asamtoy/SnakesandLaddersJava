package com.example.andrewsamtoy.snakesandladder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by andrewsamtoy on 9/13/17.
 */

public class Board {
    private HashMap<Integer, Integer> tiles;
    private int winningTile;

    public Board(int lengthOfBoard){
        winningTile = lengthOfBoard - 1;
        tiles = new HashMap<>();
    }

    public void addSpecialTile(int key, int value){
        this.tiles.put(key, value);
    }

    public Integer returnModifier(int key){
        return this.tiles.get(key);
    }

    public int getWinningTile() {
        return winningTile;
    }
}
