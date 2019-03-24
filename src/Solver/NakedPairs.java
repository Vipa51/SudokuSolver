package Solver;

import pencilNotes.*;

public class NakedPairs {
    public static void run(PencilNotes pn) {
        // Loop through lines
        for(int i = 0; i < 9; i++) {
            Line line = pn.getLine(i);
            findPairs(line);
        }

        // Loop through columns
        for(int i = 0; i < 9; i++) {
            Column col = pn.getColumn(i);
            findPairs(col);
        }

        // Loop through boxes
        for(int i = 0; i < 9; i++) {
            Box box = pn.getBox(i);
            findPairs(box);
        }
    }

    private static void findPairs(TileList tileList) {
        for(int i = 0; i < 9; i++) {
            Tile tile = tileList.getTile(i);
            checkPair(tileList, tile, i);
        }
    }

    private static void checkPair(TileList tileList, Tile tile, int i) {
        if(tile.getNumPossible() == 2) {
            for(int n = i+1; n < 9; n++) {
                if(tile.compare(tileList.getTile(n))) {
                    elimPairs(tileList, tile, i, n);
                }
            }
        }
    }

    private static void elimPairs(TileList tileList, Tile tile1, int p1, int p2) {
        // Find pair of numbers
        int num1 = -1;
        int num2 = -1;
        for(int i = 0; i < 9; i++) {
            if(tile1.getPossible(i)) {
                if(num1 == -1) {
                    num1 = i+1;
                } else {
                    num2 = i+1;
                }
            }
        }

        for(int i = 0; i < 9; i++) {
            Tile tile = tileList.getTile(i);
            if(i != p1 && i != p2){
                tile.crossOff(num1);
                tile.crossOff(num2);
            }
        }
    }
}
