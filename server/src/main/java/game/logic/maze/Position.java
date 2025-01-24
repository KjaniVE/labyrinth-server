package game.logic.maze;

import game.Direction;
import game.logic.maze.tile.Wall;
import game.logic.maze.tile.WallConfiguration;

import java.security.SecureRandom;
import java.util.Map;

public enum Position {
    TOP_LEFT(0, 0, WallConfiguration.TOP_LEFT),
    TOP_RIGHT(0, 6, WallConfiguration.TOP_RIGHT),
    BOTTOM_LEFT(6, 0, WallConfiguration.BOTTOM_LEFT),
    BOTTOM_RIGHT(6, 6, WallConfiguration.BOTTOM_RIGHT),
    RANDOM(-1, -1, null);

    private static final SecureRandom random = new SecureRandom();
    private final int row;
    private final int col;
    private final WallConfiguration wallConfig;

    Position(int row, int col, WallConfiguration wallConfig) {
        this.row = row;
        this.col = col;
        this.wallConfig = wallConfig;
    }

    public static Map<Direction, Wall> getWallsForPosition(int i, int j) {
        for (Position position : values()) {
            if (position.row == i && position.col == j) {
                return position.wallConfig.getWalls();
            }
        }
        return WallConfiguration.values()[random.nextInt(WallConfiguration.values().length)].getWalls();
    }
}