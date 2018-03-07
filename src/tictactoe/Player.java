package tictactoe;

public class Player {
    public Marker marker;
    public Player(Marker marker) {
        this.marker = marker;
    }

    public Space takeTurn(int row, int col) {
        return new Space(row, col, this.marker);
    }
}
