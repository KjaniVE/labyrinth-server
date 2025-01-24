package game.logic;

import game.logic.player.Player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static game.logic.treasure.TreasuresUtil.getAllTreasures;

public class LabyrinthServiceImpl implements LabyrinthService {

    private static final Set<Game> games = new HashSet<>();

    @Override
    public List<String> getTreasures() {
        return getAllTreasures();
    }

    @Override
    public void createGame(GameId gameId, Player player, int maximumPlayers) {
        Game game = new Game(gameId, maximumPlayers, player);
        if (!games.add(game)) {
            throw new LabyrinthException("Game already exists :(");
        }
    }
}
