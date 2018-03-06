package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RulesTest {
    private Board board;
    private Rules rules;
    private Marker player1Marker, player2Marker;
    private Player[] players;
    private Human player1, player2;

    @BeforeEach
    void setUp() throws InvalidBoardSizeException, InvalidMarkerException {
        board = new Board(3);
        rules = new Rules();
        player1Marker = new Marker('X');
        player2Marker = new Marker( 'O');
        player1 = new Human(player1Marker);
        player2 = new Human(player2Marker);
        players = new Human[] {player1, player2};
    }

    @Test
    void over() throws SpaceDoesNotExistException {
        assertTrue(rules.over(boardWithWinnerOnRows(), players));
        assertTrue(rules.over(boardWithWinnerOnColumns(), players));
        assertTrue(rules.over(boardWithWinnerOnMajorDiagonal(), players));
        assertTrue(rules.over(boardWithWinnerOnMinorDiagonal(), players));
        assertTrue(rules.over(tiedBoard(), players));
    }

    @Test
    void winnerOnColumns() throws SpaceDoesNotExistException {
        assertTrue(rules.winner(boardWithWinnerOnColumns(), players));
    }

    @Test
    void winnerOnMinorDiagonal() throws SpaceDoesNotExistException {
        assertTrue(rules.winner(boardWithWinnerOnMinorDiagonal(), players));
    }

    @Test
    void winnerOnMajorDiagonal() throws SpaceDoesNotExistException {
        assertTrue(rules.winner(boardWithWinnerOnMajorDiagonal(), players));
    }

    @Test
    void winnerOnRows() throws SpaceDoesNotExistException {
        assertTrue(rules.winner(boardWithWinnerOnRows(), players));
    }

    @Test
    void tie() throws SpaceDoesNotExistException {
        assertTrue(rules.tied(tiedBoard(), players));
    }

    @Test
    void getWinner() throws NoWinnerException, SpaceDoesNotExistException {
        assertEquals(rules.getWinner(boardWithWinnerOnRows(), players), player1);
    }

    @Test
    void throwsNoWinnerExceptionIfThereIsNoWinnerOnGetWinner() {
        assertThrows(NoWinnerException.class, () -> rules.getWinner(tiedBoard(), players));
    }

    private Board tiedBoard() throws SpaceDoesNotExistException {
        board.fillSpace(new Space(0, 0), player1Marker);
        board.fillSpace(new Space(0, 1), player2Marker);
        board.fillSpace(new Space(0, 2), player1Marker);
        board.fillSpace(new Space(1, 0), player1Marker);
        board.fillSpace(new Space(1, 1), player1Marker);
        board.fillSpace(new Space(1, 2), player2Marker);
        board.fillSpace(new Space(2, 0), player2Marker);
        board.fillSpace(new Space(2, 1), player1Marker);
        board.fillSpace(new Space(2, 2), player2Marker);
        return board;
    }

    private Board boardWithWinnerOnMajorDiagonal() throws SpaceDoesNotExistException {
        board.fillSpace(new Space(0, 0), player1Marker);
        board.fillSpace(new Space(1, 1), player1Marker);
        board.fillSpace(new Space(2, 2), player1Marker);
        return board;
    }

    private Board boardWithWinnerOnMinorDiagonal() throws SpaceDoesNotExistException {
        board.fillSpace(new Space(0, 2), player1Marker);
        board.fillSpace(new Space(1, 1), player1Marker);
        board.fillSpace(new Space(2, 0), player1Marker);
        return board;
    }

    private Board boardWithWinnerOnRows() throws SpaceDoesNotExistException {
        board.fillSpace(new Space(0, 0), player1Marker);
        board.fillSpace(new Space(0, 1), player1Marker);
        board.fillSpace(new Space(0, 2), player1Marker);
        return board;
    }

    private Board boardWithWinnerOnColumns() throws SpaceDoesNotExistException {
        board.fillSpace(new Space(0, 2), player1Marker);
        board.fillSpace(new Space(1, 2), player1Marker);
        board.fillSpace(new Space(2, 2), player1Marker);
        return board;
    }

}