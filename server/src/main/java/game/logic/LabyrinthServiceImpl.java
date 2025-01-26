package game.logic;

import game.logic.player.Player;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static game.logic.treasure.TreasuresUtil.getAllTreasures;

public class LabyrinthServiceImpl implements LabyrinthService {
    private static final String GAME_NOT_FOUND = "Game not found";


    private final Set<Game> games = new HashSet<>();

    @Override
    public List<String> getTreasures() {
        return getAllTreasures();
    }

    @Override
    public void createGame(GameId gameId, Player player, int maximumPlayers) {
        if (!games.add(new Game(gameId, maximumPlayers, player))) {
            throw new LabyrinthException("Game already exists :(");
        }
    }

    @Override
    public Set<Game> getGames(boolean accepting) {
        if (accepting) {
            Set<Game> acceptingGames = new HashSet<>();
            for (Game game : games) {
                if (game.getPlayers().size() < game.getMaxPlayers()) {
                    acceptingGames.add(game);
                }
            }
            return acceptingGames;
        } else {
            return games;
        }
    }

    @Override
    public void joinGame(GameId gameId, Player player) {
        Optional<Game> gameOptional = games.stream()
                .filter(game -> game.getId().equals(gameId))
                .findFirst();

        gameOptional.ifPresentOrElse(
                game -> game.joinGame(player),
                () -> { throw new LabyrinthResourceNotFoundException(GAME_NOT_FOUND); }
        );
    }
}
