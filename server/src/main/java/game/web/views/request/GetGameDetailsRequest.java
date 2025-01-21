package game.web.views.request;

import io.vertx.ext.web.RoutingContext;

public class GetGameDetailsRequest extends ContextBasedRequestView {
    public GetGameDetailsRequest(RoutingContext ctx) {
        super(ctx);
    }
}
