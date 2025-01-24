package game.logic.maze.tile;

import game.logic.Direction;

import java.util.EnumMap;
import java.util.Map;

public enum WallConfiguration {

    BOTTOM_RIGHT(createWalls(new Wall(false), new Wall(false), new Wall(true), new Wall(true))),
    TOP_RIGHT(createWalls(new Wall(true), new Wall(false), new Wall(false), new Wall(true))),
    TOP_LEFT(createWalls(new Wall(true), new Wall(true), new Wall(false), new Wall(false))),
    BOTTOM_LEFT(createWalls(new Wall(false), new Wall(true), new Wall(true), new Wall(false))),
    VERTICAL(createWalls(new Wall(false), new Wall(true), new Wall(false), new Wall(true))),
    HORIZONTAL(createWalls(new Wall(true), new Wall(false), new Wall(true), new Wall(false))),
    T_FACING_RIGHT(createWalls(new Wall(false), new Wall(false), new Wall(false), new Wall(true))),
    T_FACING_DOWN(createWalls(new Wall(false), new Wall(false), new Wall(true), new Wall(false))),
    T_FACING_LEFT(createWalls(new Wall(false), new Wall(true), new Wall(false), new Wall(false))),
    T_FACING_UP(createWalls(new Wall(true), new Wall(false), new Wall(false), new Wall(false)));

    private final EnumMap<Direction, Wall> walls;

    WallConfiguration(EnumMap<Direction, Wall> walls) {
        this.walls = walls;
    }

    public Map<Direction, Wall> getWalls() {
        return walls;
    }

    private static EnumMap<Direction, Wall> createWalls(Wall top, Wall right, Wall bottom, Wall left) {
        EnumMap<Direction, Wall> walls = new EnumMap<>(Direction.class);
        walls.put(Direction.TOP, top);
        walls.put(Direction.RIGHT, right);
        walls.put(Direction.BOTTOM, bottom);
        walls.put(Direction.LEFT, left);
        return walls;
    }
}