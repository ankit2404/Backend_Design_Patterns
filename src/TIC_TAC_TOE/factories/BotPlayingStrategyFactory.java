package TIC_TAC_TOE.factories;

import TIC_TAC_TOE.enums.BotDifficultyLevel;
import TIC_TAC_TOE.statergies.botStrategy.BotPlayingStrategy;
import TIC_TAC_TOE.statergies.botStrategy.EasyBotPlayingStrategy;


public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getStrategy(BotDifficultyLevel difficultyLevel){
        if(difficultyLevel == BotDifficultyLevel.EASY){
            return new EasyBotPlayingStrategy();
        }
        return new EasyBotPlayingStrategy();
    }
}
