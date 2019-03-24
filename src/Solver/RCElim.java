package Solver;

import pencilNotes.*;

public class RCElim {
    public static void run(PencilNotes pn) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                elim(pn.getLine(i, j), pn.getTile(i, j));
                elim(pn.getColumn(i, j), pn.getTile(i, j));
                elim(pn.getBox(i, j), pn.getTile(i, j));
            }
        }
    }

    private static void elim(TileList tileList, Tile tile) {
        for(int n = 0; n < 9; n++) {
            Tile t = tileList.getTile(n);
            if(t.getNumber() != 0 && (tile.getI() != t.getI() || tile.getJ() != t.getJ())) {
                tile.crossOff(t.getNumber());
            }
        }
    }
}
