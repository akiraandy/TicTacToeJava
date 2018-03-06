package tictactoe;

public class Turn {
    public String marker;
    public Space space;

    public Turn(Marker marker, Space space) {
        this.marker = marker.symbol;
        this.space = space;
    }
}
