package tictactoe;

public class Marker {
    public String symbol;

    public Marker(char letter) throws InvalidMarkerException {
        assignLetterSymbol(letter);
    }

    private void assignLetterSymbol(char letter) throws InvalidMarkerException{
        if (!Character.toString(letter).matches("[a-zA-Z]")) {
            throw new InvalidMarkerException("Marker must be a letter");
        } else {
            symbol = Character.toString(letter);
        }
    }
}
