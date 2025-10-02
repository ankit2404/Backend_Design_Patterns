package SnakeAndLadders.models;

import SnakeAndLadders.enums.GameState;
import SnakeAndLadders.enums.PlayerType;
import SnakeAndLadders.exceptions.BotCountException;
import SnakeAndLadders.exceptions.InvalidBoardSizeException;
import SnakeAndLadders.exceptions.InvalidDiceNumberException;
import SnakeAndLadders.exceptions.SnackAndLadderIsTooHuge;
import SnakeAndLadders.strategy.winningStrategies.WinningStrategy;

import java.util.List;

public class Game {

    private Board board;
    private Player winnner;
    private int currentPlayerIndex;
    private List<Move> moves;
    private List<Player> players;
    private Dice dice;
    private GameState gameState;
    private WinningStrategy winningStrategy;
    private int noOfSnakes;
    private int noOfLadders;

    public int getNoOfLadders() {
        return noOfLadders;
    }

    public void setNoOfLadders(int noOfLadders) {
        this.noOfLadders = noOfLadders;
    }

    public int getNoOfSnakes() {
        return noOfSnakes;
    }

    public void setNoOfSnakes(int noOfSnakes) {
        this.noOfSnakes = noOfSnakes;
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public Player getWinnner() {
        return winnner;
    }

    public void setWinnner(Player winnner) {
        this.winnner = winnner;
    }

    private Game(int size , List<Player> players, WinningStrategy winningStrategy, int noOfDice, int noOfLadders, int noOfSnakes){
        this.board = new Board(size, noOfLadders, noOfSnakes);
        this.players = players;
        this.winningStrategy = winningStrategy;
        this.winnner = null;
        this.gameState = GameState.IN_PROGRESS;
        this.currentPlayerIndex = 0;
        this.noOfLadders = noOfLadders;
        this.noOfSnakes = noOfSnakes;
        this.dice = new Dice(noOfDice);
    }

    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder{
        int size;
        List<Player> players;
        WinningStrategy winningStrategy;
        int noOfDice ;
        int noOfSnakes;
        int noOfLadders;


        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }


        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }
        public Builder setDice(int noOfDice) {
            this.noOfDice = noOfDice;
            return this;
        }
        public Builder setSnakes(int noOfSnakes) {
            this.noOfSnakes = noOfSnakes;
            return this;
        }
        public Builder setLadders(int noOfLadders) {
            this.noOfLadders = noOfLadders;
            return this;
        }

        private void validateBotCount(){
            int count=0;
            for(Player p:players){
                if(p.getPlayerType()== PlayerType.BOT){
                    count++;
                }
            }
            if(count>1){
                throw new BotCountException("Bot count is more then 1");
            }
        }

        private void validateboardSize(){
            if(size<3){
                throw new InvalidBoardSizeException("Board size at least 3");
            }
        }

        private void validateLadderandSnack(){
            int max=(size*size-2)/2;
            if(noOfSnakes+noOfLadders>max){
                throw new SnackAndLadderIsTooHuge("Please Use Smallnumber of snacks and ladder for better experience of Game");
            }
        }

        private void validateDiceCount(){
            if(noOfDice<1 || noOfDice> size){
                throw new InvalidDiceNumberException("For Better Dice Number use Number from "+1+" to "+noOfDice);
            }
        }

        private void validate(){
            validateBotCount();
            validateboardSize();
            validateLadderandSnack();
            validateDiceCount();
        }

        public Game build(){
            validate();
            return new Game(
                    this.size,
                    this.players,
                    this.winningStrategy,
                    this.noOfDice,
                    this.noOfLadders,
                    this.noOfSnakes
            );
        }


    }

    public void displayBoard(){
        board.displayBoard();
    }

    public void makeMove(){
        Player player = players.get(currentPlayerIndex);

        int jump = player.MakeMove(dice);
        int currentPos = player.getCurrentPosition();
        int newPos = currentPos + jump;
        int[] cord = board.getCordinates(newPos);
        Cell cell = board.getBoard()[cord[0]][cord[1]];

        if(winningStrategy.checkWinner(board.getSize(), newPos)){
            setWinnner(player);
            setGameState(GameState.SUCCESS);
            return;
        }
        if(cell.getLadder() != null){
            Ladder l = cell.getLadder();
            int end = l.getEnd();
            player.setPos(end);
            System.out.println("Congrats You got a ladder so now your position is " + end);
        } else if(cell.getSnake() != null){
            Snake s = cell.getSnake();
            int end = s.getEnd();
            player.setPos(end);
            System.out.println("You're bitten by a snake and now your position is " + end);
        }else{
            player.setPos(newPos);
            System.out.println(player.getName() + " gone up from " + currentPos + " to this " + newPos);
        }

        currentPlayerIndex=  (currentPlayerIndex+1)%players.size();


    }




}
