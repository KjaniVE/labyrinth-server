package game.web.tokens;

import game.web.LabyrinthUser;

public class PlainTextTokens implements TokenManager {

    private static final int TOKEN_GAME_ID_PART = 0;
    private static final int TOKEN_PLAYER_PART = 1;
    private static final int TOKEN_EXPECTED_PARTS = 2;

    @Override
    public String createToken(LabyrinthUser user) {
        return String.format("%s_%s", user.getGameId(), user.getPlayerName());
    }

    @Override
    public LabyrinthUser createUser(String token) {
        String[] parts = token.split("_");

        if (parts.length != TOKEN_EXPECTED_PARTS) {
            throw new InvalidTokenException();
        }

        return new LabyrinthUser(parts[TOKEN_GAME_ID_PART], parts[TOKEN_PLAYER_PART]);
    }

    @Override
    public boolean isValidPlayerName(String playerName) {
        return !playerName.contains("_");
    }

}
