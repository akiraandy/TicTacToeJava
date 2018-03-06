package tictactoe;

public class Human extends Player {
    public Human(Marker marker) {
        super(marker);
    }

    public Turn take_turn(Space space) {
        return new Turn(this.marker, space);
    }
}
