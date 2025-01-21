package game.logic.maze;

import game.logic.LabyrinthException;
import game.logic.treasure.Treasure;
import game.logic.player.Player;
import game.web.LabyrinthUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    private final Treasure treasure = new Treasure("Some treasure");

    private final boolean[] invalidWalls = new boolean[]{true, true, true, true};
    private final boolean[] validWalls = new boolean[]{false, false, true, true};

    private final Tile validTile = new Tile(treasure, validWalls);
    private final Tile randomTile = new Tile(treasure);

    @Test
    void setInvalidWalls() {
        assertThrowsExactly(LabyrinthException.class, () -> new Tile(treasure, invalidWalls));
    }

    @Test
    void getWalls() {
        assertArrayEquals(validWalls, validTile.getWalls());
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