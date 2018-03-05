package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceTest {
    private Space space;
    private Space spaceWithMarker;
    private Marker marker;

    @BeforeEach
    void setUp() throws InvalidMarkerException {
        marker = new Marker('X');
        space = new Space(2, 2);
        spaceWithMarker = new Space(2, 2, marker);
    }

    @Test
    void hasARow() {
        assertEquals(2, space.row);
    }

    @Test
    void hasAColumn() {
        assertEquals(2, space.col);
    }

    @Test
    void canBeFilledWithAMarker() {
        assertTrue(spaceWithMarker.isFilled());
    }

    @Test
    void willReturnFalseIfNotFilled() {
        assertFalse(space.isFilled());
        assertTrue(space.isEmpty());
    }

    @Test
    void canBeFilled() {
        space.fill(marker);
        assertTrue(space.isFilled());
        assertFalse(space.isEmpty());
    }

    @Test
    void canBeReset() {
        spaceWithMarker.reset();
        assertFalse(spaceWithMarker.isFilled());
        assertTrue(spaceWithMarker.isEmpty());
    }
}