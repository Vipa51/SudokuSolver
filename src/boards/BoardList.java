package boards;

import main.Constants;

import java.io.*;

public class BoardList {
    private Board[] boards = new Board[Constants.NUM_BOARDS];

    public BoardList(boolean solutions){
        try(BufferedReader br = new BufferedReader(new FileReader("src/boards/database.csv"))){
            String line;
            int i = 0;
            while((line = br.readLine()) != null && i < Constants.STARTING_BOARD + Constants.NUM_BOARDS) {
                if(i >= Constants.STARTING_BOARD) {
                    String[] values = line.split(",");
                    boards[i - Constants.STARTING_BOARD] = new Board(values[solutions ? 1 : 0]);
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Board getBoard(int i) {
        return boards[i];
    }

    public int getLength() {
        return Constants.NUM_BOARDS;
    }
}
