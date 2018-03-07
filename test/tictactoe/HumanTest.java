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
        marker = Marker.PLAYER1;
        human = new Human(marker);
        space = new Space(2, 2, marker);
    }

    @Test
    void takeTurn() {
        Space turnSpace = human.takeTurn(2, 2);
        assertEquals(turnSpace.marker, human.marker);
        assertEquals(space.row, turnSpace.row);
        assertEquals(space.col, turnSpace.col);
    }

}