package game.logic;

import game.logic.maze.Maze;
import game.logic.player.Player;

import java.util.HashSet;
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
}
