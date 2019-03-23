package pencilNotes;

public class Column {
    private Tile[] column = new Tile[9];

    public Column(Tile[] array) {
        for(int i=0; i<9; i++) {
            column[i] = array[i];
        }
    }

    public Tile getTile(int number) {
        return column[number];
    }

}
