package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnTest {

    private Turn turn;
    private Marker marker;
    private Space space;

    @BeforeEach
    void setUp() throws InvalidMarkerException {
        marker = new Marker('X');
        space = new Space(2, 2);
        turn = new Turn(marker, space);
    }

    @Test
    void hasMarker() {
        assertEquals("X", turn.marker);
    }

    @Test
    void hasSpace() {
        assertArrayEquals(new int[]{2, 2}, turn.space);
    }
}