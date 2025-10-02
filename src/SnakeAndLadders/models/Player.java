package SnakeAndLadders.models;

import SnakeAndLadders.enums.PlayerType;

import java.util.Scanner;

public class Player {
    String name;
    int id;
    Symbol symbol;
    PlayerType playerType;
    private int pos;

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public int getCurrentPosition(){
        return pos;
    }

    public Player(String name , Integer id , Symbol symbol, PlayerType playertype){
        this.name = name;
        this.id = id;
        this.symbol = symbol;
        this.playerType = playertype;
        this.pos = -1;
    }

    public int MakeMove(Dice dice){
        System.out.println(this.getName()+" Your Turn");
        System.out.println("Press 1 to make move");
        Scanner scn=new Scanner(System.in);
        int n=0;
        while(n != 1){
            n=scn.nextInt();
            return dice.rollDice();
        }
        return -1;
    }
}
