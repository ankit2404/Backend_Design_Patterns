package TIC_TAC_TOE.models;

import TIC_TAC_TOE.enums.CellState;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int n ;
    private List<List<Cell>> board;

    Board(int dimension){
        this.n = dimension;
        this.board = new ArrayList<>();
        for(int i = 0 ; i < dimension ; i++){
            List<Cell> row = new ArrayList<>();
            for(int j = 0 ; j < dimension ; j++){
                Cell c = new Cell();
                c.setRow(i);
                c.setCol(j);
                c.setCellState(CellState.EMPTY);
                row.add(c);
            }
            this.board.add(row);
        }
    }

    public int getSize(){
        return n;
    }

    void displayBoard() {
        System.out.println("Displaying board");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Cell cell = board.get(i).get(j);
                if (cell.getPlayer() == null) {
                    System.out.print("-");
                } else {
                    System.out.print(cell.getPlayer().getSymbol().getCh());
                }
            }
            System.out.println();
        }
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

}
