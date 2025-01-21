package game.logic.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerNameTest {

    PlayerName playerName = new PlayerName("test");

    @Test
    void testToString() {
        assertEquals("test", playerName.toString());
    }

    @Test
    void testEquals() {
        PlayerName playerName2 = new PlayerName("test");
        assertEquals(playerName, playerName2);
    }

    @Test
    void testHashCode() {
        PlayerName playerName2 = new PlayerName("test");
        assertEquals(playerName.hashCode(), playerName2.hashCode());
    }
}