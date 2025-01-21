package game.logic.maze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WallConfigUtilTest {

    @Test
    void contains() {
        boolean[] walls = new boolean[]{true, true, true, true};
        assertFalse(WallConfigUtil.contains(walls));

        walls = new boolean[]{false, false, true, true};
        assertTrue(WallConfigUtil.contains(walls));
    }
}