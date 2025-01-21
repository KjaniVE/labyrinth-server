package game.web;

import game.logic.GameId;
import game.logic.PlayerName;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.impl.UserImpl;

public class LabyrinthUser extends UserImpl {

    public LabyrinthUser(String gameId, String playerName) {
        super(
                new JsonObject().put("gameId", gameId).put("playerName", playerName),
                new JsonObject()
        );
    }
    public LabyrinthUser(GameId gameId, PlayerName playerName) {
        this(gameId.toString(), playerName.toString());
    }

    public GameId getGameId() {
        try {
            return new GameId(super.principal().getString("gameId"));
        } catch (IllegalArgumentException e) {
            throw new ForbiddenAccessException("Invalid gameId");
        }
    }

    public PlayerName getPlayerName() {
        return new PlayerName(super.principal().getString("playerName"));
    }
}
