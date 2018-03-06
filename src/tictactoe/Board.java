package tictactoe;

import java.util.*;

public class Board {
    public Space[][] spaces;
    private int size, boardSize;
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
        if (spaces.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        List<Space> spaces = availableSpaces();
        if (spaces.size() == boardSize) {
            return true;
        } else {
            return false;
        }
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
            this.size = size;
        }
    }

    private List<Space> availableSpaces() {
        List<Space> availableSpaces = new ArrayList<>();
        Map<Space, Boolean> statuses;
        statuses = spaceStatuses();
        for (Map.Entry<Space, Boolean> spaceEntry : statuses.entrySet()) {
            if(spaceEntry.getValue()) {
                availableSpaces.add(spaceEntry.getKey());
            }
        }
        return availableSpaces;
    }

    private boolean validSpace(Space space) {
        List<Space> spaces = availableSpaces();
        if (spaces.contains(space)){
            return true;
        } else {
            return false;
        }
    }

    private HashMap spaceStatuses() {
        HashMap<Space, Boolean> spacesStatusHash = new HashMap();
        for(int row = 0; row < this.size; row++) {
            for(int col = 0; col < this.size; col++) {
                spacesStatusHash.put(this.spaces[row][col], this.spaces[row][col].isEmpty());
            }
        }
        return spacesStatusHash;
    }

    private List<Space> unavailableSpaces() {
        List<Space> unavailableSpaces = new ArrayList<>();
        Map<Space, Boolean> statuses;
        statuses = spaceStatuses();
        for (Map.Entry<Space, Boolean> spaceEntry : statuses.entrySet()) {
            if(!spaceEntry.getValue()) {
                unavailableSpaces.add(spaceEntry.getKey());
            }
        }
        return unavailableSpaces;
    }

    private List<Space> allSpaces() {
        List <Space> spaces = new ArrayList<>();
        Set setOfAllSpaces = spaceStatuses().keySet();
        spaces.addAll(setOfAllSpaces);
        return spaces;
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
