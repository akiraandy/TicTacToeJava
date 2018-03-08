package tictactoe;

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

    public Space getBestMove(Board board) {
        if (winningMove(board) != null) {
            return winningMove(board);
        } else if (blockingMove(board) != null) {
            return blockingMove(board);
        } else if (board.center() != null) {
            return board.center();
        } else if (board.corners() != null){
            return board.corners();
        } else if (anyAvailableSpace(board) != null) {
            return anyAvailableSpace(board);
        }
        return new Space(-1, -1);
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
}
