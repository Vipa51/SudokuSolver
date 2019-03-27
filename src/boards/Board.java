package boards;

import main.Constants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Board {
    private String[][] board = new String[9][9];

    public Board(int id){
        try(BufferedReader br = new BufferedReader(new FileReader("src/boards/"+id+".csv"))){
            String line;
            int i = 0;
            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
                board[i] = values;
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Board(String str) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                board[i][j] = str.charAt(i*9 + j) + "";
            }
        }
    }

    public boolean getSolved() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == "0") {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean compareBoards(Board _board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(this.getTile(i, j) != _board.getTile(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Board(String[][] board){
        this.board = board;
    }

    public int getTile(int i, int j){
        return Integer.parseInt(board[i][j]);
    }
}
