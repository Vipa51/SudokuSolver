package Solver;

import pencilNotes.PencilNotes;
import pencilNotes.Tile;
import pencilNotes.TileList;
import java.util.ArrayList;

public class NakedTriples {
    public static void run(PencilNotes pn){
        // Loop through lines
        for (int i = 0; i < 9; i++) {
            TileList line = pn.getLine(i);
            findTriples(line);
        }

        // Loop through columns
        for (int i = 0; i < 9; i++) {
            TileList col = pn.getColumn(i);
            findTriples(col);
        }

        // Loop through boxes
        for (int i = 0; i < 9; i++) {
            TileList box = pn.getBox(i);
            findTriples(box);
        }
    }

    /*
    Pseudocode:

    Tiles with naked triples always have only 2 or 3 numbers in them, there are always 3 tiles
        -If tile has 2/3 numbers, add to a list of potential tiles (findTriples method)
        -If >2 potential tiles then naked triple is a possibility (lines 51, 52)

    potentials arraylist contains all tiles w/ 2 or 3 numbers only in them
        -If 3 tiles contain 3 unique numbers total then that that is a naked triple (checkTriples)

    eliminateTriples: eliminate those 3 unique numbers from all other tiles in the tileList except the naked triple tiles

     */






    private static void findTriples(TileList tileList) {
        ArrayList<Integer> potentials = new ArrayList<>();
        for(int i=0; i<9; i++) {
            if(tileList.getTile(i).getNumPossible() == 2 || tileList.getTile(i).getNumPossible() == 3) {
                potentials.add(i);
            }
        }
        if(potentials.size() > 2) {
            checkTriples(tileList, potentials);
        }
    }

    private static void checkTriples(TileList tileList, ArrayList<Integer> potentials) {
        for (int x = 0; x < potentials.size() - 2; x++) {
            for (int y = x + 1; y < potentials.size() - 1; y++) {
                for (int z = y + 1; z < potentials.size(); z++) {
                    ArrayList<Integer> total = new ArrayList<>();
                    ArrayList<Integer> tile1 = tileList.getTile(potentials.get(x)).getPossibleArray();
                    ArrayList<Integer> tile2 = tileList.getTile(potentials.get(y)).getPossibleArray();
                    ArrayList<Integer> tile3 = tileList.getTile(potentials.get(z)).getPossibleArray();

                    for (int i = 0; i < tile1.size(); i++) {
                        if (!total.contains(tile1.get(i))) {
                            total.add(tile1.get(i));
                        }
                    }

                    for (int i = 0; i < tile2.size(); i++) {
                        if (!total.contains(tile2.get(i))) {
                            total.add(tile2.get(i));
                        }
                    }

                    for (int i = 0; i < tile3.size(); i++) {
                        if (!total.contains(tile3.get(i))) {
                            total.add(tile3.get(i));
                        }
                    }
                    if (total.size() == 3) {
                        eliminateTriples(tileList, total, potentials.get(x), potentials.get(y), potentials.get(z));
                    }
                }
            }
        }
    }

    private static void eliminateTriples(TileList tileList, ArrayList<Integer> total, int tile1, int tile2, int tile3) {
        for(int count=0; count<3; count++) {
            for(int i=0; i<9; i++) {
                if (i != tile1 && i != tile2 && i != tile3) {
                    tileList.getTile(i).crossOff(total.get(count));
                }
            }
        }
    }
}
