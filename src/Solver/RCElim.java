package Solver;

import pencilNotes.*;

public class RCElim {
    public static void run(PencilNotes pn) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                elimLines(pn.getLine(i, j), pn.getTile(i, j));
                elimCols(pn.getColumn(i, j), pn.getTile(i, j));
                elimBoxes(pn.getBox(i, j), pn.getTile(i, j));
            }
        }
    }

    private static void elimLines(Line line, Tile tile) {
        for(int n = 0; n < 9; n++) {
            Tile t = line.getTile(n);
            if(t.getNumber() != 0 && tile.getJ() != t.getJ()) {
                tile.crossOff(t.getNumber());
            }
        }
    }

    private static void elimCols(Column col, Tile tile) {
        for(int n = 0; n < 9; n++) {
            Tile t = col.getTile(n);
            if(t.getNumber() != 0 && tile.getI() != t.getI()) {
                tile.crossOff(t.getNumber());
            }
        }
    }

    private static void elimBoxes(Box box, Tile tile) {
        for(int n = 0; n < 9; n++) {
            Tile t = box.getTile(n);
            if(t.getNumber() != 0 && tile.getJ() != t.getJ() && tile.getI() != t.getI()) {
                tile.crossOff(t.getNumber());
            }
        }
    }
}
