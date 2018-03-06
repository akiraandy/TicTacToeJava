package tictactoe;

public class Turn {
    public Marker marker;
    public Space space;

    public Turn(Space space) {
        this.marker = space.marker;
        this.space = space;
    }
}
