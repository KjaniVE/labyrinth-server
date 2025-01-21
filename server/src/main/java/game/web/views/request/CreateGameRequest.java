package game.web.views.request;

import io.vertx.ext.web.RoutingContext;

public class CreateGameRequest extends ContextBasedRequestView {
    public CreateGameRequest(RoutingContext ctx) {
        super(ctx);
    }
}
