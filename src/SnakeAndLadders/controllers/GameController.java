package SnakeAndLadders.controllers;

import SnakeAndLadders.enums.GameState;
import SnakeAndLadders.models.Game;
import SnakeAndLadders.models.Player;
import SnakeAndLadders.strategy.winningStrategies.WinningStrategy;

import java.util.List;

public class GameController {
    private static volatile GameController instance;

    private GameController(){

    }

    public static GameController getInstance(){
        if(instance==null){
            synchronized (GameController.class){
                if(instance==null){
                    instance=new GameController();
                }
            }
        }
        return  instance;
    }

    public Game initializeGame(int size, List<Player> players, WinningStrategy winningStrategy, int noOfDice, int noOfLadders, int noOfSnakes){
        return Game.getBuilder().
                setPlayers(players).
                setSize(size).
                setWinningStrategy(winningStrategy).
                setDice(noOfDice).
                setLadders(noOfLadders).
                setSnakes(noOfSnakes).
                build();
    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public void displayBoard(Game game){
        game.displayBoard();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public Player getWinner(Game game){
        return game.getWinnner();
    }

}

