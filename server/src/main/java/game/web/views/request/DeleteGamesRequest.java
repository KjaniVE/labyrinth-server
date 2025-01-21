package game.web.views.request;

import io.vertx.ext.web.RoutingContext;

public class DeleteGamesRequest extends ContextBasedRequestView {
    public DeleteGamesRequest(RoutingContext ctx) {
        super(ctx);
    }
}
