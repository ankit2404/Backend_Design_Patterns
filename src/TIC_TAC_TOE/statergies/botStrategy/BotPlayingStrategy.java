package TIC_TAC_TOE.statergies.botStrategy;

import TIC_TAC_TOE.models.Board;
import TIC_TAC_TOE.models.Bot;
import TIC_TAC_TOE.models.Move;
public interface BotPlayingStrategy {

    public Move makeMove(Board board, Bot bot);
}
