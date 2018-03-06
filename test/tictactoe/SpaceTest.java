package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceTest {
    private Space space;
    private Space spaceWithMarker;
    private Marker marker;
    private int row, col;

    @BeforeEach
    void setUp() throws InvalidMarkerException {
        row = 2;
        col = 2;
        marker = new Marker('X');
        space = new Space(row, col);
        spaceWithMarker = new Space(row, col, marker);
    }

    @Test
    void hasARow() {
        assertEquals(row, space.row);
    }

    @Test
    void hasAColumn() {
        assertEquals(col, space.col);
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

    @Test
    void isSame() {
        Space newSpace = new Space(row, col);
        assertTrue(space.isSame(newSpace));
        assertTrue(spaceWithMarker.isSame(newSpace));
        Space anotherSpace = new Space(1, 2);
        assertFalse(space.isSame(anotherSpace));
    }
}