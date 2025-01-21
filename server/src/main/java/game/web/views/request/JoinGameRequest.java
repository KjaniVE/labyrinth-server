package game.web.views.request;

import io.vertx.ext.web.RoutingContext;

public class JoinGameRequest extends ContextBasedRequestView {
    public JoinGameRequest(RoutingContext ctx) {
        super(ctx);
    }
}
