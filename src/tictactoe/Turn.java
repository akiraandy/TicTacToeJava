package tictactoe;

public class Turn {
    public String marker;
    public int space[];

    public Turn(Marker marker, Space space) {
        this.marker = marker.symbol;
        this.space = new int[]{space.row, space.col};
    }
}
