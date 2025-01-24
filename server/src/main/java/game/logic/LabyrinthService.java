package game.logic;

import game.logic.player.Player;

import java.util.List;

public interface LabyrinthService {
    List<String> getTreasures();

    void createGame(GameId gameId, Player player, int maximumPlayers);
}
