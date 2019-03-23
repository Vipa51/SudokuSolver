package pencilNotes;

public class TileList {
    private Tile[] list = new Tile[9];

    public TileList(Tile[] array) {
        for(int i=0; i<9; i++) {
            list[i] = array[i];
        }
    }

    public Tile getTile(int number) {
        return list[number];
    }
}
