package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnTest {

    private Turn turn;
    private Marker marker = Marker.PLAYER1;
    private Space space;

    @BeforeEach
    void setUp() throws InvalidMarkerException {
        space = new Space(2, 2, marker);
        turn = new Turn(space);
    }

    @Test
    void hasMarker() {
        assertEquals(Marker.PLAYER1, turn.marker);
    }

    @Test
    void hasSpace() {
        assertEquals(space, turn.space);
    }
}