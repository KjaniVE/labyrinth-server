package game.web.views.response;

import game.logic.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GetGamesResponse extends ResponseWithHiddenStatus {
    private final List<Game> games = new ArrayList<>();

    public GetGamesResponse(Set<Game> games) {
        super(200);
        putGamesInList(games);
    }

    private void putGamesInList(Set<Game> games) {
        this.games.addAll(games);
    }

    public List<Game> getGames() {
        return games;
    }
}
