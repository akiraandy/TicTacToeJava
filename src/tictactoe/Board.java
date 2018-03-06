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

    public void fillSpace(Space space, Marker marker) throws SpaceDoesNotExistException {
        Space spaceToFill = getSpace(space);
        List<Space> spaces = availableSpaces();
        if (validSpace(spaceToFill)) {
            spaces.get(spaces.indexOf(spaceToFill)).fill(marker);
        }
    }

    public void resetSpace(Space space) throws SpaceDoesNotExistException {
        Space spaceToReset = getSpace(space);
        List<Space> spaces = unavailableSpaces();
        spaces.get(spaces.indexOf(spaceToReset)).reset();
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

    private List<Space> availableSpaces() {
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
        List<Space> spaces = availableSpaces();
        return spaces.contains(space);
    }

    private List<Space> unavailableSpaces() {
        List<Space> unavailableSpaces = new ArrayList<>();
        for(int row = 0; row < this.rowSize; row++) {
            for (int col = 0; col < this.rowSize; col++) {
                if (spaces[row][col].isFilled()) {
                    unavailableSpaces.add(spaces[row][col]);
                }
            }
        }
        return unavailableSpaces;
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
}
