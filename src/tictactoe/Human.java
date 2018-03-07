package tictactoe;

public class Human extends Player {
    public Human(Marker marker) {
        super(marker);
    }

    public Space takeTurn(int row, int col) {
        return new Space(row, col, this.marker);
    }
}
