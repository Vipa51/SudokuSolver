package Solver;

import pencilNotes.*;

public class HiddenSingles {
    public static void run(PencilNotes pn) {
        // Loop through lines
        for(int i = 0; i < 9; i++) {
            TileList line = pn.getLine(i);
            findLast(line);
        }

        // Loop through columns
        for(int i = 0; i < 9; i++) {
            TileList col = pn.getColumn(i);
            findLast(col);
        }

        // Loop through boxes
        for(int i = 0; i < 9; i++) {
            TileList box = pn.getBox(i);
            findLast(box);
        }
    }

    public static void findLast (TileList tileList){
        for(int n = 0; n < 9; n++) {
            int count = 0;
            Tile lastTile = null;
            for(int t = 0; t < 9; t++) {
                Tile tile = tileList.getTile(t);
                if(tile.getPossible(n)) {
                    count++;
                    lastTile = tile;
                }
            }
            if(count == 1) {
                lastTile.setNumber(n);
            }
        }
    }
}
