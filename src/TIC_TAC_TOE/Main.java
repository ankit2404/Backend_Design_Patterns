package TIC_TAC_TOE;

import TIC_TAC_TOE.controllers.GameController;
import TIC_TAC_TOE.enums.GameState;
import TIC_TAC_TOE.enums.PlayerType;
import TIC_TAC_TOE.models.Game;
import TIC_TAC_TOE.models.Player;
import TIC_TAC_TOE.models.Symbol;
import TIC_TAC_TOE.statergies.winningStrategies.OrderOneWinningStrategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Player Ankit = new Player("Ankit", new Symbol('X'),1, PlayerType.HUMAN);
        Player Luke = new Player("Luke", new Symbol('0'), 2, PlayerType.HUMAN);
//        Player Raj = new Player("Raj", new Symbol('Y'), 3, PlayerType.HUMAN);

        Game game = gameController.inintializeGame(3, Arrays.asList(Ankit,Luke), new OrderOneWinningStrategy(3));

        gameController.displayBoard(game);
        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
            gameController.makeMove(game);
            gameController.displayBoard(game);
        }
        if(gameController.getGameState(game).equals(GameState.DRAW)){
            System.out.println("GAME is DRAW");
        }else{
            Player winner = gameController.getWinner(game);
            System.out.println(winner.getName() + " is the winner");
        }


    }
}
