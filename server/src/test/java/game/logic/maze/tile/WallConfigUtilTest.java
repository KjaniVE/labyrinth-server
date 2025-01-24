package game.logic.maze.tile;

import game.logic.Direction;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WallConfigUtilTest {

    @Test
    void testConstructor() {
        assertThrows(UnsupportedOperationException.class, WallConfigUtil::new);
    }

@Test
void contains() {
    Map<Direction, Wall> walls = Map.of(
        Direction.TOP, new Wall(true),
        Direction.RIGHT, new Wall(true),
        Direction.BOTTOM, new Wall(true),
        Direction.LEFT, new Wall(true)
    );
    assertFalse(WallConfigUtil.contains(walls));

    walls = Map.of(
        Direction.TOP, new Wall(false),
        Direction.RIGHT, new Wall(false),
        Direction.BOTTOM, new Wall(true),
        Direction.LEFT, new Wall(true)
    );
    assertTrue(WallConfigUtil.contains(walls));
}
}