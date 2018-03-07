package tictactoe;

public class Human extends Player {
    public Human(Marker marker) {
        super(marker);
    }

    public Space takeTurn(Space space) {
        return space.fill(this.marker);
    }
}
