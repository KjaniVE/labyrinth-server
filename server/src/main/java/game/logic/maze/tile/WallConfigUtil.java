package game.logic.maze.tile;

import game.logic.Direction;

import java.util.Map;

public class WallConfigUtil {

    protected WallConfigUtil() {
        throw new UnsupportedOperationException("This class is not instantiable");
    }

    public static boolean contains(Map<Direction, Wall> walls) {
        return walls.values().stream().anyMatch(wall -> !wall.exists());
    }
}
