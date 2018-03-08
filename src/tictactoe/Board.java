package tictactoe;


import java.util.ArrayList;
import java.util.List;

public class Board {
    public Space[][] spaces;
    public int rowSize, boardSize;
    private int EMPTY_BOARD_SIZE = 0;
    public Board(int size) throws InvalidBoardSizeException {
        checkIfValidBoardSize(size);
        initializeSpaces();
        boardSize = size * size;
    }

    public void fillSpace(Space space) throws SpaceDoesNotExistException {
        if (validSpace(space)) {
            getSpace(space).fill(space.marker);
        }
    }

    public void resetSpace(Space space) throws SpaceDoesNotExistException {
        getSpace(space).reset();
    }

    public boolean isFull() {
        List<Space> spaces = availableSpaces();
        return spaces.size() == EMPTY_BOARD_SIZE;
    }

    public boolean isEmpty() {
        List<Space> spaces = availableSpaces();
        return spaces.size() == boardSize;
    }

    private Space getSpace(Space space) throws SpaceDoesNotExistException {
        List<Space> spaces = allSpaces();
        for (Space currentSpace : spaces) {
            if (currentSpace.isSame(space)) {
                return currentSpace;
            }
        }
        throw new SpaceDoesNotExistException("Space does not exist on board");
    }

    private void checkIfValidBoardSize(int size) throws InvalidBoardSizeException {
        if(size < 3) {
            throw new InvalidBoardSizeException("Board size must be greater than 3");
        } else {
            this.rowSize = size;
        }
    }

    public List<Space> availableSpaces() {
        List<Space> availableSpaces = new ArrayList<>();
        for(int row = 0; row < this.rowSize; row++) {
            for (int col = 0; col < this.rowSize; col++) {
                if (spaces[row][col].isEmpty()) {
                    availableSpaces.add(spaces[row][col]);
                }
            }
        }
        return availableSpaces;
    }

    private boolean validSpace(Space space) {
        for (Space spaceInSpaces : availableSpaces()) {
            if (spaceInSpaces.isSame(space)) {
                return true;
            }
        }
        return false;
    }

    private List<Space> allSpaces() {
        List<Space> allSpaces = new ArrayList<>();
        for(int row = 0; row < this.rowSize; row++) {
            for (int col = 0; col < this.rowSize; col++) {
                    allSpaces.add(spaces[row][col]);
            }
        }
        return allSpaces;
    }

    private void initializeSpaces() {
        this.spaces = new Space[this.rowSize][this.rowSize];
        for (int rowIndex = 0; rowIndex < this.rowSize; rowIndex++) {
            for (int colIndex = 0; colIndex < this.rowSize; colIndex++) {
                this.spaces[rowIndex][colIndex] = new Space(rowIndex, colIndex);
            }
        }
    }

    public Space center() {
        if (availableSpaces().size() % 2 != 0 && spaces[1][1].isEmpty()) {
            return spaces[1][1];
        }
        return null;
    }

    public Space corners() {
        List<Space> corners = new ArrayList<>();
        corners.add(spaces[0][0]);
        corners.add(spaces[0][rowSize - 1]);
        corners.add(spaces[rowSize - 1][0]);
        corners.add(spaces[rowSize - 1][rowSize - 1]);
        for(Space space : availableSpaces()) {
            if (corners.contains(space)) {
                return space;
            }
        }
        return null;
    }
}
