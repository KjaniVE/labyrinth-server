package game.logic.maze;

import game.logic.Direction;
import game.logic.Location;
import game.logic.maze.tile.Wall;
import game.logic.maze.tile.WallConfiguration;

import java.security.SecureRandom;
import java.util.Map;

public enum Position {
    TOP_LEFT(new Location(0, 0), WallConfiguration.TOP_LEFT),
    TOP_RIGHT(new Location(0, 6), WallConfiguration.TOP_RIGHT),
    BOTTOM_LEFT(new Location(6, 0), WallConfiguration.BOTTOM_LEFT),
    BOTTOM_RIGHT(new Location(6, 6), WallConfiguration.BOTTOM_RIGHT),
    RANDOM( null, null);

    private static final SecureRandom random = new SecureRandom();
    private final Location location;
    private final WallConfiguration wallConfig;

    Position(Location location, WallConfiguration wallConfig) {
        this.location = location;
        this.wallConfig = wallConfig;
    }

    public static Map<Direction, Wall> getWallsForPosition(Location location) {
        for (Position position : values()) {
            if (location.equals(position.location)) {
                return position.wallConfig.getWalls();
            }
        }
        return WallConfiguration.values()[random.nextInt(WallConfiguration.values().length)].getWalls();
    }
}