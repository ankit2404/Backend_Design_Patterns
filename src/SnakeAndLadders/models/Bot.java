package SnakeAndLadders.models;


import SnakeAndLadders.enums.PlayerType;

import java.util.Scanner;

public class Bot extends Player{

    public Bot(String name, int id, Symbol symbol, PlayerType playerType) {
        super(name, id, symbol, playerType);
    }

    public int MakeMove(Dice dice){
        System.out.println("It's bot Turn");
        return dice.rollDice();
    }
}
