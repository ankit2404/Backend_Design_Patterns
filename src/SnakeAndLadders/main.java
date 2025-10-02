package SnakeAndLadders;


import SnakeAndLadders.controllers.GameController;
import SnakeAndLadders.enums.GameState;
import SnakeAndLadders.enums.PlayerType;
import SnakeAndLadders.models.*;
import SnakeAndLadders.strategy.winningStrategies.ExactlyHundred;

import java.util.Arrays;

public class main {

    public static void main(String[] args) {

        GameController gameController = new GameController();

        Player Ankit = new Player("Ankit", 1, new Symbol('A'), PlayerType.HUMAN);

        Player Modi = new Player("Modi", 2, new Symbol('M'), PlayerType.HUMAN);

        Player Bot = new Bot("Bot", 3, new Symbol('B'), PlayerType.BOT);

        int noOfDice = 1;
        int noOfSnakes = 5;
        int noOfLadders = 5;

        Game game = gameController.initializeGame(10, Arrays.asList(Ankit,Modi, Bot), new ExactlyHundred(), noOfDice, noOfLadders, noOfSnakes);

        gameController.displayBoard(game);
        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
            gameController.makeMove(game);
            gameController.displayBoard(game);
        }

        if(gameController.getGameState(game).equals(GameState.SUCCESS)){
            System.out.println(gameController.getWinner(game).getName() + " is the winner 😊😊😊😊");
        }

    }
}
