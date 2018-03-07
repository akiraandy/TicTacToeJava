package tictactoe;

public abstract class Player {
    public Marker marker;
    public Player(Marker marker) {
        this.marker = marker;
    }

    public Space takeTurn(Space space) {
        return null;
    }
}
