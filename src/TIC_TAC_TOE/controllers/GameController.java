package TIC_TAC_TOE.controllers;

import TIC_TAC_TOE.enums.GameState;
import TIC_TAC_TOE.models.Game;
import TIC_TAC_TOE.models.Player;
import TIC_TAC_TOE.statergies.winningStrategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game inintializeGame(int dimension, List<Player> players, WinningStrategy winningStrategy){
        return Game.getBuilder().
                setDimension(dimension).
                setPlayers(players).
                setWinningStatergy(winningStrategy).
                build();
    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void displayBoard(Game game){
        game.displayBoard();
    }
    public void makeMove(Game game){
        game.makeMove();
    }

}
