package game.web.views.response;

import java.util.List;

public class GetTreasuresResponse extends ResponseWithHiddenStatus {

    private final List<String> treasures;

    public GetTreasuresResponse(List<String> treasures) {
        super(200);
        this.treasures = treasures;
    }

    public List<String> getTreasures() {
        return treasures;
    }
}
