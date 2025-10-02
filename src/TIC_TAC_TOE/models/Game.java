package TIC_TAC_TOE.models;

import TIC_TAC_TOE.enums.GameState;
import TIC_TAC_TOE.statergies.winningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();
    private Player winner;
    private Board board;
    private int currentPlayerIndex;
    private List<Move> moves;
    private GameState gameState ;
    private WinningStrategy winningStrategy;

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    private Game(int dimension,List<Player> players, WinningStrategy winningStrategy){
        this.players = players;
        this.board = new Board(dimension);
        this.winningStrategy = winningStrategy;
        this.winner = null;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.currentPlayerIndex = 0;
    }
    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder{
        private int dimension;
        private List<Player> players;
        private WinningStrategy winningStrategy;

        public Builder setDimension(int dimension){
            this.dimension = dimension;
            return this;
        }
        public Builder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }
        public Builder setWinningStatergy(WinningStrategy winningStatergy){
            this.winningStrategy = winningStatergy;
            return this;
        }
        public Game build(){
            return new Game(
                    this.dimension,
                    this.players,
                    this.winningStrategy
            );
        }
    }

    public void displayBoard(){
        board.displayBoard();
    }

    public void makeMove(){
        Player currentPlayer = players.get(currentPlayerIndex);
        Move move =  currentPlayer.makeMove(board);
        moves.add(move);

        if(winningStrategy.checkWinner(move, board)){
            this.gameState = GameState.SUCCESS;
            setWinner(currentPlayer);
            return;
        }
        if(moves.size() == board.getSize()* board.getSize()){
            setGameState(GameState.DRAW);
            return;
        }

        currentPlayerIndex = (currentPlayerIndex+1)% players.size();
    }




}
