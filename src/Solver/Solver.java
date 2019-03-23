package Solver;

import boards.Board;
import pencilNotes.PencilNotes;

public class Solver {
    public Board solve(PencilNotes pn) {
        for(int i = 0; i < 30; i++) {
            RCElim.run(pn);
            HiddenSingles.run(pn);
            NakedPairs.run(pn);
        }
        return pn.getBoard();
    }
}
