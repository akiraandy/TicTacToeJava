package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RulesTest {
    private Board board;
    private Rules rules;
    private Player player1, player2;
    private Player[] players;

    @BeforeEach
    void setUp() throws InvalidBoardSizeException, InvalidPlayerNumberException {
        board = new Board(3);
        rules = new Rules();
        player1 = new Player(1);
        player2 = new Player(2);
    }

    @Test
    void over() throws SpaceDoesNotExistException {
        assertTrue(rules.over(boardWithWinnerOnRows()));
        assertTrue(rules.over(boardWithWinnerOnColumns()));
        assertTrue(rules.over(boardWithWinnerOnMajorDiagonal()));
        assertTrue(rules.over(boardWithWinnerOnMinorDiagonal()));
        assertTrue(rules.over(tiedBoard()));
    }

    @Test
    void winnerOnColumns() throws SpaceDoesNotExistException {
        assertTrue(rules.winner(boardWithWinnerOnColumns()));
    }

    @Test
    void winnerOnMinorDiagonal() throws SpaceDoesNotExistException {
        assertTrue(rules.winner(boardWithWinnerOnMinorDiagonal()));
    }

    @Test
    void winnerOnMajorDiagonal() throws SpaceDoesNotExistException {
        assertTrue(rules.winner(boardWithWinnerOnMajorDiagonal()));
    }

    @Test
    void winnerOnRows() throws SpaceDoesNotExistException {
        assertTrue(rules.winner(boardWithWinnerOnRows()));
    }

    @Test
    void tie() throws SpaceDoesNotExistException {
        assertTrue(rules.tied(tiedBoard()));
    }

    @Test
    void getWinner() throws NoWinnerException, SpaceDoesNotExistException {
        assertEquals(rules.getWinner(boardWithWinnerOnRows()), player1.marker);
    }

    @Test
    void throwsNoWinnerExceptionIfThereIsNoWinnerOnGetWinner() {
        assertThrows(NoWinnerException.class, () -> rules.getWinner(tiedBoard()));
    }

    private Board tiedBoard() throws SpaceDoesNotExistException {
        board.fillSpace(new Space(0, 0, player1));
        board.fillSpace(new Space(0, 1, player2));
        board.fillSpace(new Space(0, 2, player1));
        board.fillSpace(new Space(1,  0, player1));
        board.fillSpace(new Space(1,  1, player1));
        board.fillSpace(new Space(1,  2, player2));
        board.fillSpace(new Space(2,  0, player2));
        board.fillSpace(new Space(2,  1, player1));
        board.fillSpace(new Space(2,  2, player2));
        return board;
    }

    private Board boardWithWinnerOnMajorDiagonal() throws SpaceDoesNotExistException {
        board.fillSpace(new Space(0, 0, player1));
        board.fillSpace(new Space(1, 1, player1));
        board.fillSpace(new Space(2, 2, player1));
        return board;
    }

    private Board boardWithWinnerOnMinorDiagonal() throws SpaceDoesNotExistException {
        board.fillSpace(new Space(0, 2, player1));
        board.fillSpace(new Space(1, 1, player1));
        board.fillSpace(new Space(2, 0, player1));
        return board;
    }

    private Board boardWithWinnerOnRows() throws SpaceDoesNotExistException {
        board.fillSpace(new Space(0, 0, player1));
        board.fillSpace(new Space(0, 1, player1));
        board.fillSpace(new Space(0, 2, player1));
        return board;
    }

    private Board boardWithWinnerOnColumns() throws SpaceDoesNotExistException {
        board.fillSpace(new Space(0, 2, player1));
        board.fillSpace(new Space(1, 2, player1));
        board.fillSpace(new Space(2, 2, player1));
        return board;
    }
}