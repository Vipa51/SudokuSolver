package Solver;

import boards.Board;
import pencilNotes.PencilNotes;

public class Solver {
    public Board solve(PencilNotes pn) {
        for(int i = 0; i < 10; i++) {
            RCElim.run(pn);
        }
        return pn.getBoard();
    }
}
