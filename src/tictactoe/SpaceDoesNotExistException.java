package tictactoe;

public class SpaceDoesNotExistException extends Exception{
    public SpaceDoesNotExistException(String message) {
        super(message);
    }
}
