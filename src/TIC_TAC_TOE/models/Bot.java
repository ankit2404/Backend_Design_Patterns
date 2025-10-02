package TIC_TAC_TOE.models;

import TIC_TAC_TOE.enums.BotDifficultyLevel;
import TIC_TAC_TOE.enums.PlayerType;
import TIC_TAC_TOE.factories.BotPlayingStrategyFactory;
import TIC_TAC_TOE.statergies.botStrategy.BotPlayingStrategy;

import java.util.Scanner;

public class Bot extends Player{

    BotDifficultyLevel botDifficultyLevel;

    public Bot(String name, int id, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, id, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board){
        System.out.println("Its " + getName() + "'s turn");
        BotPlayingStrategy strategy = BotPlayingStrategyFactory.getStrategy(botDifficultyLevel);
        Move move = strategy.makeMove(board, this);
        System.out.println("Bot made a move on row:" + move.getCell().getRow() + " col:" + move.getCell().getCol());
        return move;
    }
}
