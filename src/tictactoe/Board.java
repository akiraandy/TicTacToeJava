package tictactoe;

public class Board {
    public Space[][] spaces;
    private int size;
    public Board(int size) throws InvalidBoardSizeException {
        checkIfValidBoardSize(size);
        initializeSpaces();
    }

    private void checkIfValidBoardSize(int size) throws InvalidBoardSizeException {
        if(size < 3) {
           throw new InvalidBoardSizeException("Board size must be greater than 3");
        } else {
            this.size = size;
        }
    }

    private void initializeSpaces() {
        this.spaces = new Space[this.size][this.size];
        for (int rowIndex = 0; rowIndex < this.size; rowIndex++) {
            for (int colIndex = 0; colIndex < this.size; colIndex++) {
                this.spaces[rowIndex][colIndex] = new Space(rowIndex, colIndex);
            }
        }
    }
}
