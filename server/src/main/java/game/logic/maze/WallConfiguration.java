package game.logic.maze;

public enum WallConfiguration {

    BOTTOM_RIGHT(new boolean[]{false, false, true, true}),
    TOP_RIGHT(new boolean[]{true, false, false, true}),
    TOP_LEFT(new boolean[]{true, true, false, false}),
    BOTTOM_LEFT(new boolean[]{false, true, true, false}),
    VERTICAL(new boolean[]{false, true, false, true}),
    HORIZONTAL(new boolean[]{true, false, true, false}),
    T_FACING_RIGHT(new boolean[]{false, false, false, true}),
    T_FACING_DOWN(new boolean[]{false, false, true, false}),
    T_FACING_LEFT(new boolean[]{false, true, false, false}),
    T_FACING_UP(new boolean[]{true, false, false, false});

    private final boolean[] walls;

    WallConfiguration(boolean[] walls) {
        this.walls = walls;
    }

    public boolean[] getWalls() {
        return walls;
    }
}
