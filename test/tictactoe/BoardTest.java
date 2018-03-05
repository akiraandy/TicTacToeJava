package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;
    private int size;
    private int invalidSize;
    @BeforeEach
    void setUp() throws InvalidBoardSizeException {
        size = 3;
        invalidSize = 0;
        board = new Board(size);
    }

    @Test
    void throwsErrorIfBoardSizeIsTooSmall() throws InvalidBoardSizeException {
        assertThrows(InvalidBoardSizeException.class, () -> new Board(invalidSize));
    }
}