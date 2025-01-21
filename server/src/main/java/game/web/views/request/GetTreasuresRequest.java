package game.web.views.request;

import io.vertx.ext.web.RoutingContext;

public class GetTreasuresRequest extends ContextBasedRequestView {
    public GetTreasuresRequest(RoutingContext ctx) {
        super(ctx);
    }

}
