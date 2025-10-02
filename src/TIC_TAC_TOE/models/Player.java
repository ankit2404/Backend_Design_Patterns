package TIC_TAC_TOE.models;

import TIC_TAC_TOE.enums.CellState;
import TIC_TAC_TOE.enums.PlayerType;

import java.util.Scanner;

public class Player {
    private String name ;
    private Symbol symbol;
    private Integer id;
    private PlayerType playerType;

    public Player(String name, Symbol symbol, Integer id, PlayerType playerType){
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Move makeMove(Board board){
        Scanner scn = new Scanner(System.in);
        System.out.println("It's " + name + "'s turn");
        System.out.println("Enter the row number 0 indexed basis");
        int row = scn.nextInt();
        System.out.println("Enter the column number 0 indexed basis");
        int col = scn.nextInt();
        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);

        Move move = new Move();
        move.setCell(cell);
        move.setPlayer(this);
        return move;

    }

}
