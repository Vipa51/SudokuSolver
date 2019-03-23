package pencilNotes;

public class Box {
    Tile[] box = new Tile[9];

    public Box(Tile[] array) {
        for(int i=0; i<9; i++) {
            box[i] = array[i];
        }
    }

    public Tile getTile(int number) {
        return box[number];
    }

}
