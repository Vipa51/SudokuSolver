package main;

import boards.Board;

public class Main {
    public static void main(String args[]) {
        Board board = new Board(0);
        System.out.println(board.getTile(3, 4));
    }
}
