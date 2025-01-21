package game.web.views.request;

import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.validation.RequestParameters;
import io.vertx.ext.web.validation.ValidationHandler;

public abstract class ContextBasedRequestView {

    protected final RoutingContext ctx;
    protected final RequestParameters params;

    ContextBasedRequestView(RoutingContext ctx) {
        this.ctx = ctx;
        this.params = ctx.get(ValidationHandler.REQUEST_CONTEXT_KEY);
    }

    @SuppressWarnings("unchecked")
    protected <T> T getUser() {
        return (T) ctx.user();
    }
}
