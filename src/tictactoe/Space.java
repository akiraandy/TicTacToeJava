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
        this.marker = Marker.EMPTY;
    }

    public boolean isSame(Space space) {
        return this.row == space.row && this.col == space.col;
    }

    public boolean isFilled() {
        return this.marker != Marker.EMPTY;
    }

    public Space fill(Marker marker) {
        this.marker = marker;
        return this;
    }

    public void reset() {
        this.marker = Marker.EMPTY;
    }

    public boolean isEmpty() {
        return this.marker == Marker.EMPTY;
    }
}
