package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player1, player2;
    private Marker marker;
    private Space space;
    private Board board;
    @BeforeEach
    void setUp() throws InvalidMarkerException, InvalidBoardSizeException, InvalidPlayerNumberException {
        marker = Marker.PLAYER1;
        player1 = new Player(1);
        player2 = new Player(2);
        space = new Space(2, 2, player1);
        board = new Board(3);
    }

    @Test
    void takeTurn() {
        Space turnSpace = player1.takeTurn(2, 2);
        assertEquals(turnSpace.marker, player1.marker);
        assertEquals(space.row, turnSpace.row);
        assertEquals(space.col, turnSpace.col);
    }

    @Test
    void getBestMoveWhenOpponentCanWin() throws SpaceDoesNotExistException {
        board.fillSpace(new Space(0, 0, player2));
        board.fillSpace(new Space(1,1, player2));
        Space winningSpace = new Space(2,2);
        assertTrue(winningSpace.isSame(player1.getBestMove(board)));
    }

    @Test
    void willTakeAnyAvailableSpace() throws SpaceDoesNotExistException {
        board.fillSpace(new Space( 0, 0, player2));
        board.fillSpace(new Space( 0, 2, player2));
        board.fillSpace(new Space( 2, 0, player2));
        board.fillSpace(new Space(2,2, player2));
        board.fillSpace(new Space(1,1, player2));
        Space move = new Space(0, 1);
        assertTrue(move.isSame(player1.getBestMove(board)));
    }

    @Test
    void getBestMoveWhenCornerAvailable() throws SpaceDoesNotExistException {
        board.fillSpace(new Space(1, 1, player2));
        Space move = new Space(0, 0);
        assertTrue(move.isSame(player1.getBestMove(board)));
    }

    @Test
    void getBestMoveWhenCenterAvailable() throws SpaceDoesNotExistException {
        board.fillSpace(new Space(0,2, player2));
        board.fillSpace(new Space(2,2, player1));
        Space move = new Space(1, 1);
        Space center = player1.getBestMove(board);
        assertTrue(move.isSame(center));
    }

    @Test
    void getBestMoveWhenPlayerCanWin() throws SpaceDoesNotExistException {
        board.fillSpace(new Space(0, 0, player1));
        board.fillSpace(new Space(0,1, player1));
        Space winningSpace = new Space(0, 2);
        assertTrue(winningSpace.isSame(player1.getBestMove(board)));
    }
}