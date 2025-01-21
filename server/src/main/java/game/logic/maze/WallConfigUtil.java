package game.logic.maze;

import java.util.Arrays;

public class WallConfigUtil {

    protected WallConfigUtil() {
        throw new UnsupportedOperationException("This class is not instantiable");
    }

    public static boolean contains(boolean[] walls) {
        for (WallConfiguration config : WallConfiguration.values()) {
            if (Arrays.equals(config.getWalls(), walls)) {
                return true;
            }
        }
        return false;
    }
}
