package SnakeAndLadders.models;

import SnakeAndLadders.enums.CellState;

import java.util.Random;

public class Board {
    int size ;
    Cell[][] board;
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }



    Board(int size, int ladders, int snakes){
        this.size = size;
        board = new Cell[size][size];
        for(int i = 0 ; i < size; i++){
            for(int j = 0 ; j < size; j++){
                Cell c = new Cell();
                c.setRow(i);
                c.setCol(j);
                board[i][j] = c;
            }
        }
        addLadders(ladders);
        addSnakes(snakes);
    }

    public void displayBoard(){
        for(int i = 0 ; i < size; i++){
            for (int j =0 ; j < size; j++){
                if(board[i][j].getSnake() != null){
                    System.out.print(" ❌ ");
                }else if(board[i][j].getLadder() != null){
                    System.out.print(" ✔️ ");
                }else{
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }

    public int[] getCordinates(int pos){
        int [] cords=new int[2];
        cords[0]=size-1-pos/size;
        if((pos/size)%2==0){
            cords[1]=pos%size;
        }else{
            cords[1]=(size-1-pos%size);
        }
        return cords;
    }

    public void addSnakes(int snakes){
        Random r = new Random();
        int low = 1;
        int high = (size*size) -1;
        while(snakes > 0){
            int start = r.nextInt(high -low) + low;
            int end = r.nextInt(high - low) + low;

            if(start == end){
                continue;
            }
            int min = Math.min(start, end);
            int max = Math.max(start,end);
            start = max;
            end = min;
            int[] startCordinates = getCordinates(start);
            int[] endCordinates = getCordinates(end);

            if(board[startCordinates[0]][startCordinates[1]].getSnake() != null ||
                    board[startCordinates[0]][startCordinates[1]].getLadder() != null ||
                    board[endCordinates[0]][endCordinates[1]].getSnake() != null ||
                    board[endCordinates[0]][endCordinates[1]].getLadder() != null){
                continue;
            }else{
                Snake s = new Snake(start , end);
                System.out.println("Snack created "+start+" "+end+" pos cordinats is startpoint= "+ startCordinates[0]+" "+startCordinates[1]+" endpoint= "+endCordinates[0]+" "+endCordinates[1]);
                Cell cell = board[startCordinates[0]][startCordinates[1]];
                cell.setSnake(s);
            }

            snakes--;

        }
    }

    public void addLadders(int ladders) {
        Random r = new Random();
        int low = 1;
        int high = (size * size) - 1;
        while (ladders > 0) {
            int start = r.nextInt(high - low) + low;
            int end = r.nextInt(high - low) + low;

            if (start == end) {
                continue;
            }
            int min = Math.min(start, end);
            int max = Math.max(start, end);
            start = min;
            end = max;
            int[] startCordinates = getCordinates(start);
            int[] endCordinates = getCordinates(end);

            if (board[startCordinates[0]][startCordinates[1]].getSnake() != null ||
                    board[startCordinates[0]][startCordinates[1]].getLadder() != null ||
                    board[endCordinates[0]][endCordinates[1]].getSnake() != null ||
                    board[endCordinates[0]][endCordinates[1]].getLadder() != null) {
                continue;
            } else {
                Ladder ld = new Ladder(start, end);
                System.out.println("Ladders created " + start + " " + end + " pos cordinats is startpoint= " + startCordinates[0] + " " + startCordinates[1] + " endpoint= " + endCordinates[0] + " " + endCordinates[1]);
                Cell cell = board[startCordinates[0]][startCordinates[1]];
                cell.setLadder(ld);
            }

            ladders--;
        }
    }


}
