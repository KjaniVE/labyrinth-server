package game.web.views.request;

import io.vertx.ext.web.RoutingContext;

public class LeaveGameRequest extends ContextBasedRequestView {
    public LeaveGameRequest(RoutingContext ctx) {
        super(ctx);
    }
}
