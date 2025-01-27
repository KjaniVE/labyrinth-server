package game.logic;

import game.logic.maze.Maze;
import game.logic.player.Player;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Game {

    private static final int NUMBER_OF_TREASURES_PER_PLAYER = 3;

    private final GameId id;
    private final Maze maze;
    private final Set<Player> players = new HashSet<>();
    private final int maxPlayers;

    public Game(GameId id, int maxPlayers, Player player) {
        this.id = id;
        this.maze = new Maze();
        this.maxPlayers = maxPlayers;
        players.add(player);
    }

    public GameId getId() {
        return id;
    }

    public Maze getMaze() {
        return maze;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void joinGame(Player player) {
        if (players.size() < maxPlayers) {
            players.add(player);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
