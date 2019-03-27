package main;

import Solver.Solver;
import boards.Board;
import boards.BoardList;
import pencilNotes.PencilNotes;

public class Main {
    public static void main(String args[]) {
        if(Constants.USE_DATABASE) {
            BoardList puzzles = new BoardList(false);
            BoardList solutions = new BoardList(true);
            int puzzles_solved = 0;
            for(int i = 0; i < puzzles.getLength(); i++) {
                Board solvedBoard = solveBoard(puzzles.getBoard(i), false);
                if(!solvedBoard.compareBoards(solutions.getBoard(i))) {
                    System.out.println("Puzzle " + (i + Constants.STARTING_BOARD) + " Failed!");
                } else {
                    puzzles_solved++;
                }
                if(i % 1000 == 0) System.out.println("Finished puzzle #" + (i + Constants.STARTING_BOARD)); // Effectively a progress bar
            }
            System.out.println(puzzles_solved + "/" + puzzles.getLength() + " puzzles solved!");
        } else {
            Board board = new Board(Constants.BOARD_ID);
            solveBoard(board, true);
        }
    }

    private static Board solveBoard(Board board, boolean print) {
        PencilNotes pn = new PencilNotes(board);

        Solver solver = new Solver();
        solver.solve(pn);

        if(print) {
            print(pn);
        }

        return pn.getBoard();
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
        System.out.printf("\n");
    }
}
