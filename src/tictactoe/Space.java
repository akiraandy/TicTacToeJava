package tictactoe;

public class Space {
    public int row, col;
    public Marker marker;

    public Space(int row, int col, Marker marker) {
        this.row = row;
        this.col = col;
        this.marker = marker;
    }

    public Space(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean isSame(Space space) {
        if (this.row == space.row && this.col == space.col) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFilled() {
        if(this.marker != null) {
            return true;
        } else {
            return false;
        }
    }

    public void fill(Marker marker) {
        this.marker = marker;
    }

    public void reset() {
        this.marker = null;
    }

    public boolean isEmpty() {
        if(this.marker == null) {
            return true;
        } else {
            return false;
        }
    }
}
