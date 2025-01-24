package game.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void setRow() {
        Location test = new Location(0, 0);
        test.setRow(1);
        assertEquals(1, test.getRow());
    }

    @Test
    void setCol() {
        Location test = new Location(0, 0);
        test.setCol(1);
        assertEquals(1, test.getCol());
    }

    @Test
    void testConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Location(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> new Location(0, -1));
        assertThrows(IllegalArgumentException.class, () -> new Location(7, 0));
        assertThrows(IllegalArgumentException.class, () -> new Location(0, 7));
    }

    @Test
    void testToString() {
        Location test = new Location(0, 0);
        assertEquals("(row: 0, col: 0)", test.toString());
    }

    @Test
    void testEquals() {
        Location test = new Location(0, 0);
        Location test2 = new Location(0, 0);
        assertEquals(test, test2);
    }

    @Test
    void testHashCode() {
        Location test = new Location(0, 0);
        Location test2 = new Location(0, 0);
        assertEquals(test2.hashCode(), test.hashCode());
    }
}