package game.web.views.request;

import game.logic.GameId;
import game.logic.player.Player;
import game.web.LabyrinthUser;
import io.vertx.ext.web.RoutingContext;

public class CreateGameRequest extends ContextBasedRequestView {
    public CreateGameRequest(RoutingContext ctx) {
        super(ctx);
    }

    public GameId getGameId() {
        return new GameId(params.body().getJsonObject().getString("gameName"));
    }

    public Player getPlayer() {
        return new Player(new LabyrinthUser(getGameId().toString(), params.body().getJsonObject().getString("playerName")));
    }

    public int getMaximumPlayers() {
        return params.body().getJsonObject().getInteger("maximumPlayers");
    }
}
