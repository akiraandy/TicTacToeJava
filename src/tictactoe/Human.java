package tictactoe;

public class Human extends Player {
    public Human(Marker marker) {
        super(marker);
    }

    public Turn takeTurn(Space space) {
        space = new Space(space.row, space.col, this.marker);
        return new Turn(space);
    }
}
