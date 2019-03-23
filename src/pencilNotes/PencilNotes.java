package pencilNotes;

import boards.Board;

import java.util.ArrayList;
import java.util.List;

public class PencilNotes {
    private Tile[][] notes = new Tile[9][9];
    private Line[] lines = new Line[9];
    private Column[] columns = new Column[9];
    private Box[] boxes = new Box[9];

    public PencilNotes(Board board) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
               notes[i][j] = new Tile(board.getTile(i, j), i, j);
            }
        }

        for(int i=0; i<9; i++) {
            Tile[] array = new Tile[9];
            for(int j=0; j<9; j++) {
                array[j] = notes[i][j];
            }
            lines[i] = new Line(array);
        }

        for(int j=0; j<9; j++) {
            Tile[] array = new Tile[9];
            for(int i=0; i<9; i++) {
                array[i] = notes[i][j];
            }
            columns[j] = new Column(array);
        }

        boxes[0] = createBox(0, 0);
        boxes[1] = createBox(0, 3);
        boxes[2] = createBox(0, 6);
        boxes[3] = createBox(3, 0);
        boxes[4] = createBox(3, 3);
        boxes[5] = createBox(3, 6);
        boxes[6] = createBox(6, 0);
        boxes[7] = createBox(6, 3);
        boxes[8] = createBox(6, 6);
    }

    public Tile getTile(int i, int j) {
        return notes[i][j];
    }

    public Line getLine(int i, int j) {
        return lines[i];
    }

    public Column getColumn(int i, int j) {
        return columns[j]
    }

    public Box createBox(int i, int j) {
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

    public Box getBox(int i, int j) {
        int topLeftI = i-(i%3);
        int topLeftJ = j-(j%3);
        return boxes[topLeftI+topLeftJ/3];
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
