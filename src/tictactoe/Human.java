package tictactoe;

public class Human extends Player {
    public Human(Marker marker) {
        super(marker);
    }

    public Space takeTurn(Space space) {
        return new Space(space.row, space.col, this.marker);
    }
}
