package game.logic.maze;

import game.Direction;
import game.logic.LabyrinthException;
import game.logic.maze.tile.Tile;
import game.logic.maze.tile.Wall;
import game.logic.maze.tile.WallConfigUtil;
import game.logic.treasure.Treasure;
import game.logic.player.Player;
import game.web.LabyrinthUser;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    private final Treasure treasure = new Treasure("Some treasure");

    private final Map<Direction, Wall> invalidWalls = Map.of(
            Direction.TOP, new Wall(true),
            Direction.RIGHT, new Wall(true),
            Direction.BOTTOM, new Wall(true),
            Direction.LEFT, new Wall(true)
    );

    private final Map<Direction, Wall> validWalls = Map.of(
            Direction.TOP, new Wall(false),
            Direction.RIGHT, new Wall(false),
            Direction.BOTTOM, new Wall(true),
            Direction.LEFT, new Wall(true)
    );

    private final Tile validTile = new Tile(treasure, validWalls);
    private final Tile randomTile = new Tile(treasure);

    @Test
    void setInvalidWalls() {
        assertThrowsExactly(LabyrinthException.class, () -> new Tile(treasure, invalidWalls));
    }

    @Test
    void getWalls() {
        assertEquals(validWalls, validTile.getWalls());
        assertTrue(WallConfigUtil.contains(randomTile.getWalls()));
    }

    @Test
    void getTreasure() {
        assertEquals(treasure, randomTile.getTreasure());
    }

    @Test
    void setTreasure() {
        Treasure newTreasure = new Treasure("New treasure");
        randomTile.setTreasure(newTreasure);
        assertEquals(newTreasure, randomTile.getTreasure());
    }

    @Test
    void addPlayerAndGetPlayer() {
        final Player player = new Player(new LabyrinthUser("test", "test"));
        validTile.addPlayer(player);
        assertTrue(validTile.getPlayers().contains(player));

        // Player can only be added once
        validTile.addPlayer(player);
        assertEquals(1, validTile.getPlayers().size());
    }

    @Test
    void removePlayer() {
        final Player player = new Player(new LabyrinthUser("test", "test"));
        validTile.addPlayer(player);
        assertTrue(validTile.getPlayers().contains(player));
        validTile.removePlayer(player);
        assertFalse(validTile.getPlayers().contains(player));
    }

    @Test
    void removeTreasure() {
        randomTile.removeTreasure();
        assertNull(randomTile.getTreasure());
    }

    @Test
    void testEquals() {
        assertEquals(validTile, new Tile(treasure, validWalls));
    }

    @Test
    void testHashCode() {
        assertEquals(validTile.hashCode(), new Tile(treasure, validWalls).hashCode());
    }
}