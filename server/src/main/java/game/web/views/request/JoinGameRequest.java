package game.web.views.request;

import game.logic.GameId;
import game.logic.player.Player;
import game.web.LabyrinthUser;
import io.vertx.ext.web.RoutingContext;

public class JoinGameRequest extends ContextBasedRequestView {
    public JoinGameRequest(RoutingContext ctx) {
        super(ctx);
    }

    public Player getPlayer() {
        return new Player(new LabyrinthUser(getGameId().toString(), params.pathParameter("playerName").getString()));
    }

    public GameId getGameId() {
        return new GameId(params.pathParameter("gameId").getString());
    }
}
