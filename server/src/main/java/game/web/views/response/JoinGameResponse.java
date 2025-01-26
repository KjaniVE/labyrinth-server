package game.web.views.response;

@SuppressWarnings("unused")
public class JoinGameResponse extends ResponseWithHiddenStatus {

    private final String token;
    private final String playerName;
    private final String gameId;

    public JoinGameResponse(String gameId, String playerName, String token) {
        super(200);
        this.gameId = gameId;
        this.playerName = playerName;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getGameId() {
        return gameId;
    }
}
