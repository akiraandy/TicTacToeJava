package tictactoe;

public abstract class Player {
    public Marker marker;
    public Player(Marker marker) {
        this.marker = marker;
    }

    public Turn take_turn(Space space) {
        return null;
    }
}
