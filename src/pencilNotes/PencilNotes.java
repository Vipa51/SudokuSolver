package pencilNotes;

import boards.Board;

import java.util.ArrayList;
import java.util.List;

public class PencilNotes {
    private Tile[][] notes = new Tile[9][9];


    public PencilNotes(Board board) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
               notes[i][j] = new Tile(board.getTile(i, j), i, j);
            }
        }
    }

    public Tile getTile(int i, int j) {
        return notes[i][j];
    }

    public Line getLine(int i, int j) {
        Tile[] array = new Tile[9];
        for(int x=0; x<9; x++) {
            array[x] = notes[i][x];
        }
        return new Line(array);
    }

    public Column getColumn(int i, int j) {
        Tile[] array = new Tile[9];
        for(int x=0; x<9; x++) {
            array[x] = notes[x][j];
        }
        return new Column(array);
    }

    public Box getBox(int i, int j) {
        Tile[] array = new Tile[9];
        int topLeftI = i-(i%3);
        int topLeftJ = j-(j%3);

        array[0] = notes[topLeftI][topLeftJ];
        array[1] = notes[topLeftI][topLeftJ+1];
        array[2] = notes[topLeftI][topLeftJ+2];
        array[3] = notes[topLeftI+1][topLeftJ];
        array[4] = notes[topLeftI+1][topLeftJ+1];
        array[5] = notes[topLeftI+1][topLeftJ+2];
        array[6] = notes[topLeftI+2][topLeftJ];
        array[7] = notes[topLeftI+2][topLeftJ+1];
        array[8] = notes[topLeftI+2][topLeftJ+2];

        return new Box(array);
    }

    public Board getBoard() {
        String[][] board = new String[9][9];

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                board[i][j] =  ""+getTile(i, j).getNumber();
            }
        }

        return new Board(board);
    }
}
