package uno.util;

public class NotEnoughPlayersException extends Exception {
    public NotEnoughPlayersException(int playerCount) {
        super("Only " + playerCount + " players were given");
    }
}
