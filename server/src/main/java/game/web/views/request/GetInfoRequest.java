package game.web.views.request;

import io.vertx.ext.web.RoutingContext;

public class GetInfoRequest extends ContextBasedRequestView {
    public GetInfoRequest(RoutingContext ctx) {
        super(ctx);
    }
}
