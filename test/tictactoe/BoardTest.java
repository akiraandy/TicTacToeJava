package tictactoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;
    private Marker marker;
    private int size, invalidSize, row, col;

    @BeforeEach
    void setUp() throws InvalidBoardSizeException, InvalidMarkerException {
        size = 3;
        invalidSize = 0;
        row = 2;
        col = 2;
        marker = Marker.PLAYER1;
        board = new Board(size);
    }

    @AfterEach
    void tearDown() throws InvalidBoardSizeException {
        board = new Board(size);
    }

    @Test
    void fillsASpace() throws SpaceDoesNotExistException {
        Space space = board.spaces[row][col].fill(marker);
        board.fillSpace(space);
        assertTrue(board.spaces[row][col].isFilled());
    }

    @Test
    void resetsASpace() throws SpaceDoesNotExistException {
        Space space = board.spaces[row][col].fill(marker);
        board.resetSpace(space);
        assertTrue(board.spaces[row][col].isEmpty());
    }

    @Test
    void throwsErrorIfSpaceDoesNotExistOnBoard() {
        Space space = new Space(100, 100);
        assertThrows(SpaceDoesNotExistException.class, () -> board.resetSpace(space));
    }

    @Test
    void isFull() throws InvalidBoardSizeException, SpaceDoesNotExistException {
        Board fullBoard = fullBoard();
        assertTrue(fullBoard.isFull());
        assertFalse(board.isFull());
    }

    @Test
    void isEmpty() {
        assertTrue(board.isEmpty());
    }

    @Test
    void throwsErrorIfBoardSizeIsTooSmall() throws InvalidBoardSizeException {
        assertThrows(InvalidBoardSizeException.class, () -> new Board(invalidSize));
    }

    private Board fullBoard() throws InvalidBoardSizeException, SpaceDoesNotExistException {
        Board fullBoard;
        fullBoard = new Board(size);
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                Space space = fullBoard.spaces[row][col].fill(marker);
                fullBoard.fillSpace(space);
            }
        }
        return fullBoard;
    }

}