package game.logic;

public abstract class GameResourceNotFoundException extends RuntimeException {
    protected GameResourceNotFoundException(String message) {
        super(message);
    }
}
