package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    private Human human;
    private Marker marker;
    private Space space;
    @BeforeEach
    void setUp() throws InvalidMarkerException {
        marker = new Marker('X');
        human = new Human(marker);
        space = new Space(2, 2);
    }

    @Test
    void takeTurn() {
        Turn turn = human.take_turn(space);
        assertEquals(turn.marker, human.marker.symbol);
        assertEquals(space, turn.space);
    }

}