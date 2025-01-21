package game.logic.maze;

import game.logic.LabyrinthException;
import game.logic.treasure.Treasure;
import game.logic.player.Player;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Tile {

    private static final SecureRandom random = new SecureRandom();

    private boolean[] walls;
    private Treasure treasure;
    private final Set<Player> players = new HashSet<>();

    public Tile(Treasure treasure, boolean[] walls) {
        setWalls(walls);
        this.treasure = treasure;
    }

    private void setWalls(boolean[] walls) {
        if (WallConfigUtil.contains(walls)) {
            this.walls = walls;
        } else {
            throw new LabyrinthException("Invalid wall configuration");
        }
    }

    public Tile(Treasure treasure) {
        this(treasure, WallConfiguration.values()[random.nextInt(WallConfiguration.values().length)].getWalls());
    }

    public boolean[] getWalls() {
        return walls;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void removeTreasure() {
        treasure = null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return Objects.deepEquals(walls, tile.walls) && Objects.equals(treasure, tile.treasure) && Objects.equals(players, tile.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(walls), treasure, players);
    }
}
