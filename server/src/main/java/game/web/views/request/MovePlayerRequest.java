package game.web.views.request;

import io.vertx.ext.web.RoutingContext;

public class MovePlayerRequest extends ContextBasedRequestView {
    public MovePlayerRequest(RoutingContext ctx) {
        super(ctx);
    }
}
