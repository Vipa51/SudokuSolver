package main;

import Solver.Solver;
import boards.Board;
import pencilNotes.PencilNotes;

public class Main {
    private static final int BOARD_ID = 5;

    public static void main(String args[]) {
        Board board = new Board(BOARD_ID);

        PencilNotes pn = new PencilNotes(board);

        Solver solver = new Solver();
        solver.solve(pn);
        print(pn);
    }

    private static void print(PencilNotes pn) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                int number = pn.getTile(i, j).getNumber();
                if(number != 0) {
                    System.out.printf(number + " ");
                } else {
                    System.out.printf("  ");
                }
            }
            System.out.printf("\n");
        }
    }
}
