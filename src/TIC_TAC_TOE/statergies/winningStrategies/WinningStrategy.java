package TIC_TAC_TOE.statergies.winningStrategies;

import TIC_TAC_TOE.models.Board;
import TIC_TAC_TOE.models.Move;

public interface WinningStrategy {
    public boolean checkWinner(Move move , Board board);
}
