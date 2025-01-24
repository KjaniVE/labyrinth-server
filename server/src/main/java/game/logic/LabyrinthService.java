package game.logic;

import game.logic.player.Player;

import java.util.List;
import java.util.Set;

public interface LabyrinthService {
    List<String> getTreasures();

    void createGame(GameId gameId, Player player, int maximumPlayers);

    Set<Game> getGames(boolean accepting);
}
