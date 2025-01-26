package game.web.views.request;

import io.vertx.ext.web.RoutingContext;

public class GetGamesRequest extends ContextBasedRequestView {
    public GetGamesRequest(RoutingContext ctx) {
        super(ctx);
    }

    public boolean isAccepting() {
        return params.queryParameter("accepting").getBoolean();
    }
}
