package pencilNotes;

public class Line {
    private Tile[] line = new Tile[9];

    public Line(Tile[] array) {
        for(int i=0; i<9; i++) {
            line[i] = array[i];
        }
    }

    public Tile getTile(int number) {
        return line[number];
    }

}
