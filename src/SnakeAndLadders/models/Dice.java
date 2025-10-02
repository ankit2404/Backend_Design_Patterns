package SnakeAndLadders.models;

import java.util.Random;

public class Dice {
    int min;
    int max;
    Dice(int dice){
        this.min = dice;
        this.max = dice* 6;
    }
    public int rollDice(){
        Random r = new Random();
        int val = r.nextInt(max-min) + min;
        System.out.println("Dice rolled "+val);
        return val;
    }

}
