package game.web;

import java.io.Serial;

public class ForbiddenAccessException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ForbiddenAccessException(String message) {
        super(message);
    }
}

