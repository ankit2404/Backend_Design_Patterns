package SnakeAndLadders.strategy.winningStrategies;

public class ExactlyHundred implements WinningStrategy{

    @Override
    public boolean checkWinner(int boardSize, int pos){
        if(boardSize*boardSize-1 <= pos){
            return true;
        }
        return false;
    }
}
