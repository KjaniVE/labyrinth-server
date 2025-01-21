package game.web.views.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageResponse extends ResponseWithHiddenStatus {

    @JsonProperty private final String message;
    public MessageResponse(int status, String message) {
        super(status);
        this.message = message;
    }
}
