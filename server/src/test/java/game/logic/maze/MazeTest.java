package game.logic.maze;

import game.logic.maze.tile.Tile;
import game.logic.maze.tile.WallConfiguration;
import game.logic.treasure.Treasure;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    @Test
void testCorners() {
    Maze maze = new Maze();

    // Topleft corner
    assertEquals(WallConfiguration.TOP_LEFT.getWalls(), maze.getBoard()[0][0].getWalls());

    // Topright corner
    assertEquals(WallConfiguration.TOP_RIGHT.getWalls(), maze.getBoard()[0][6].getWalls());

    // Bottomleft corner
    assertEquals(WallConfiguration.BOTTOM_LEFT.getWalls(), maze.getBoard()[6][0].getWalls());

    // Bottomright corner
    assertEquals(WallConfiguration.BOTTOM_RIGHT.getWalls(), maze.getBoard()[6][6].getWalls());
}

    @Test
    void testTreasuresAmount() {
        Maze maze = new Maze();
        Tile[][] board = maze.getBoard();
        int treasures = 0;
        for (Tile[] row : board) {
            for (Tile tile : row) {
                if (tile.getTreasure() != null) {
                    treasures++;
                }
            }
        }
        assertEquals(24, treasures);
    }

    @Test
    void checkUniqueTreasures() {
        Maze maze = new Maze();
        Tile[][] board = maze.getBoard();
        Set<Treasure> foundTreasures = new HashSet<>();

        for (Tile[] tiles : board) {
            for (Tile tile : tiles) {
                Treasure treasure = tile.getTreasure();
                if (treasure != null) {
                    assertTrue(foundTreasures.add(treasure), "Treasure " + treasure + " is not unique");
                }
            }
        }
    }
}