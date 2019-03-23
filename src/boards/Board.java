package boards;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<List<String>> board;

    public Board(int id){
        board = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src/boards/"+id+".csv"))){
            String line;
            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
                board.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getTile(int x, int y){
        return Integer.parseInt(board.get(y).get(x));
    }
}
