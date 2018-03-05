package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarkerTest {
    private Marker m;
    @BeforeEach
    void setUp() throws InvalidMarkerException {
        m = new Marker('X');
    }

    @Test
    public void acceptsOnlyLetters() {
        assertThrows(InvalidMarkerException.class, () -> new Marker('+'));
        assertThrows(InvalidMarkerException.class, () -> new Marker('\n'));
    }

    @Test
    public void hasSymbol() {
        assertEquals("X", m.symbol);
    }
}