package Solver;

import pencilNotes.*;
import java.util.ArrayList;

public class HiddenPairs {
    public static void run(PencilNotes pn) {
        // Loop through lines
        for(int i = 0; i < 9; i++) {
            Line line = pn.getLine(i);
            findDoubles(line);
        }

        // Loop through columns
        for(int i = 0; i < 9; i++) {
            Column col = pn.getColumn(i);
            findDoubles(col);
        }

        // Loop through boxes
        for(int i = 0; i < 9; i++) {
            Box box = pn.getBox(i);
            findDoubles(box);
        }
    }

    private static void findDoubles(TileList tileList) {
        ArrayList<Integer> pairs = new ArrayList<>();
        for(int i=0; i<9; i++) {
            int count=0;
            for(int j=0; j<9; j++) {
                if(tileList.getTile(j).getPossible(i)) {
                    count++;
                }
            }
            if(count == 2) {
                pairs.add(i);
            }
        }
        if(pairs.size() > 1) {
            checkDoubles(tileList, pairs);
        }
    }

    private static void checkDoubles(TileList tileList, ArrayList<Integer> pairs) {
        ArrayList<Integer> boxNums = new ArrayList<>();
        for(int i=0; i<pairs.size(); i++) {
            for(int j=0; j<9; j++) {
                if(tileList.getTile(j).getPossible(pairs.get(i))) {
                    boxNums.add(j);
                }
            }
        }

        for(int i=0; i<boxNums.size(); i+=2) {
            for(int j=i+2; j<boxNums.size()-2; j+=2) {
                if(boxNums.get(i) == boxNums.get(j)) {
                    if(boxNums.get(i+1) == boxNums.get(j+1)) {
                        for(int x=0; (x!=pairs.get(i/2) && x!=pairs.get(j/2)); x++) {
                            tileList.getTile(boxNums.get(i)).crossOff(x+1);
                            tileList.getTile(boxNums.get(i+1)).crossOff(x+1);
                        }
                    }
                }
            }
        }
    }
}
