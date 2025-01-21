package game.web.views.request;

import io.vertx.ext.web.RoutingContext;

public class GetReachableLocationsRequest extends ContextBasedRequestView {
    public GetReachableLocationsRequest(RoutingContext ctx) {
        super(ctx);
    }
}
