package pencilNotes;

public class Tile {
    private int i;
    private int j;
    private Boolean[] possibleNums = new Boolean[9];

    public Tile(int number, int x, int y) {
        i = x;
        j = y;
        if(number == 0) {
            for(int i=0; i<9; i++) {
                possibleNums[i] = true;
            }
        }
        else {
            for(int i=0; i<9; i++) {
                possibleNums[i]=false;
            }
            possibleNums[number-1]=true;
        }
    }

    public int getNumPossible() {
        int count = 0;
        for(int i = 0; i < 9; i++) {
            if(possibleNums[i]) {
                count++;
            }
        }
        return count;
    }

    public Boolean getPossible(int number) {
        if(possibleNums[number]) {
            return true;
        }
        return false;
    }

    public void crossOff(int number) {
        possibleNums[number-1] = false;
    }

    public int getNumber() {
        int count = 0;
        for(int i=0; i<9; i++) {
            if(possibleNums[i]) {
                count++;
            }
        }
        if(count == 1) {
            for(int i=0; i<9; i++) {
                if (possibleNums[i]) {
                    return i + 1;
                }
            }
        }
        return 0;
    }

    public boolean compare(Tile tile) {
        for(int i = 0; i < 9; i++) {
            if(possibleNums[i] != tile.getPossible(i)) {
                return false;
            }
        }
        return true;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setNumber(int number) {
        for(int i=0; i<9; i++) {
            if(i == number) {
                possibleNums[i] = true;
            }

            else {
                possibleNums[i] = false;
            }
        }
    }
}
