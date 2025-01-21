package game.logic.maze;

import java.security.SecureRandom;

public enum Position {
    TOP_LEFT(0, 0, new boolean[]{true, false, false, true}),
    TOP_RIGHT(0, 6, new boolean[]{true, true, false, false}),
    BOTTOM_LEFT(6, 0, new boolean[]{false, false, true, true}),
    BOTTOM_RIGHT(6, 6, new boolean[]{false, true, true, false}),
    RANDOM(-1, -1, null);

    private static final SecureRandom random = new SecureRandom();
    private final int row;
    private final int col;
    private final boolean[] walls;

    Position(int row, int col, boolean[] walls) {
        this.row = row;
        this.col = col;
        this.walls = walls;
    }

    public static boolean[] getWallsForPosition(int i, int j) {
        for (Position position : values()) {
            if (position.row == i && position.col == j) {
                return position.walls;
            }
        }
        return WallConfiguration.values()[random.nextInt(WallConfiguration.values().length)].getWalls();
    }
}