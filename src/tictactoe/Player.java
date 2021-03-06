package tictactoe;

import java.util.List;

public class Player {
    public Marker marker;
    private Rules rules;
    private Marker opponent;
    private static final int PLAYER_ONE = 1;
    private static final int PLAYER_TWO = 2;
    public Player(int playerNum) throws InvalidPlayerNumberException {
        this.marker = getMarker(playerNum);
        this.opponent = getOpponentMarker();
        this.rules = new Rules();
    }

    public Space takeTurn(int row, int col) {
        return new Space(row, col, this);
    }

    public Space getBestMove(Board board) throws SpaceDoesNotExistException {
        if (winningMove(board) != null) {
            return winningMove(board);
        } else if (blockingMove(board) != null) {
            return blockingMove(board);
        } else if (board.center().isEmpty()) {
            return board.center();
        } else if (chooseCorner(board.corners()) != null){
            return chooseCorner(board.corners());
        } else if (anyAvailableSpace(board) != null) {
            return anyAvailableSpace(board);
        }
        throw new SpaceDoesNotExistException("There are no available spaces on the board");
    }

    private Space chooseCorner(List<Space> corners){
        for (Space corner : corners) {
            if (corner.isEmpty()) {
                return corner;
            }
        }
        return null;
    }

    private Space winningMove(Board board) {
        for (Space space : board.availableSpaces()) {
            space.fill(marker);
            if (rules.winner(board)){
                space.reset();
                return space;
            }
            space.reset();
        }
        return null;
    }

    private Space blockingMove(Board board) {
        for (Space space : board.availableSpaces()) {
            space.fill(opponent);
            if (rules.winner(board)) {
                space.reset();
                return space;
            }
            space.reset();
        }
        return null;
    }

    private Space anyAvailableSpace(Board board) {
        for (Space space : board.availableSpaces()) {
            if (space.isEmpty()) {
                return space;
            }
        }
        return null;
    }

    private Marker getMarker(int playerNum) throws InvalidPlayerNumberException {
        if (playerNum == PLAYER_ONE) {
            return Marker.PLAYER1;
        } else if (playerNum == PLAYER_TWO) {
            return Marker.PLAYER2;
        } else {
            throw new InvalidPlayerNumberException("Player number must be either 1 or 2");
        }
    }

    private Marker getOpponentMarker() {
        if (marker == Marker.PLAYER1) {
            return Marker.PLAYER2;
        } else {
            return Marker.PLAYER1;
        }
    }
}
