package tictactoe;

import java.util.ArrayList;

public class Rules {
    public boolean winner(Board board) {
        for (ArrayList<Space> line : winningCombinations(board)) {
            if ((line.stream().allMatch(space -> space.marker == Marker.PLAYER1) || (line.stream().allMatch(space -> space.marker == Marker.PLAYER2)))){
                return true;
            }
        }
        return false;
    }

    public Player getWinner(Board board, Player[] players) throws NoWinnerException {
        for (ArrayList<Space> line : winningCombinations(board)) {
            if (line.stream().allMatch(space -> space.marker == players[0].marker)){
                return players[0];
            } else if (line.stream().allMatch(space -> space.marker == players[1].marker)) {
                return players[1];
            }
        }
        throw new NoWinnerException("The current game does not have a winner");
    }

    public boolean tied(Board board) {
        return board.isFull() && !winner(board);
    }

    public boolean over(Board board) {
        return tied(board) || winner(board);
    }

    private ArrayList<ArrayList<Space>> winningCombinations(Board board) {
        ArrayList<ArrayList<Space>> winningCombinations = new ArrayList<>();
        winningCombinations.addAll(getRows(board));
        winningCombinations.addAll(getColumnns(board));
        winningCombinations.add(getMajorDiagonal(board));
        winningCombinations.add(getMinorDiagonal(board));
        return winningCombinations;
    }

    private ArrayList<ArrayList<Space>> getRows(Board board) {
        ArrayList<ArrayList<Space>> rows = new ArrayList<>(board.rowSize);
        for(int rowNum = 0; rowNum < board.rowSize; rowNum++) {
            ArrayList<Space> row = new ArrayList<>();
            for (int colNum = 0; colNum < board.rowSize; colNum++) {
                row.add(board.spaces[rowNum][colNum]);
            }
            rows.add(row);
        }
        return rows;
    }

    private ArrayList<ArrayList<Space>> getColumnns(Board board) {
        ArrayList<ArrayList<Space>> columns = new ArrayList<>(board.rowSize);
        for(int rowNum = 0; rowNum < board.rowSize; rowNum++) {
            ArrayList<Space> column = new ArrayList<>();
            for (int colNum = 0; colNum < board.rowSize; colNum++) {
                column.add(getRows(board).get(colNum).get(rowNum));
            }
            columns.add(column);
        }
        return columns;
    }

    private ArrayList<Space> getMajorDiagonal(Board board) {
        ArrayList<Space> majorDiagonal = new ArrayList<>(board.rowSize);
        for (int i = 0; i < board.rowSize; i++){
            majorDiagonal.add(getRows(board).get(i).get(i));
        }
        return majorDiagonal;
    }

    private ArrayList<Space> getMinorDiagonal(Board board) {
        ArrayList<Space> minorDiagonal = new ArrayList<>(board.rowSize);
        for (int i = 0; i < board.rowSize; i++){
            minorDiagonal.add(getRows(board).get(i).get(board.rowSize - (i + 1)));
        }
        return minorDiagonal;
    }
}
