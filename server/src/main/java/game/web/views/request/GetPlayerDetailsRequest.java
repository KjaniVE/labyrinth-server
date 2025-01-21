package game.web.views.request;

import io.vertx.ext.web.RoutingContext;

public class GetPlayerDetailsRequest extends ContextBasedRequestView {
    public GetPlayerDetailsRequest(RoutingContext ctx) {
        super(ctx);
    }
}
