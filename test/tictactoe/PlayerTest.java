package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;
    private Marker marker;
    private Space space;
    @BeforeEach
    void setUp() throws InvalidMarkerException {
        marker = Marker.PLAYER1;
        player = new Player(marker);
        space = new Space(2, 2, marker);
    }

    @Test
    void takeTurn() {
        Space turnSpace = player.takeTurn(2, 2);
        assertEquals(turnSpace.marker, player.marker);
        assertEquals(space.row, turnSpace.row);
        assertEquals(space.col, turnSpace.col);
    }

}