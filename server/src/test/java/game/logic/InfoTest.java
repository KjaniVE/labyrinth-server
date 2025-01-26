package game.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfoTest {

    @Test
    void getVersion() {
        assertEquals("v0.0.1", Info.getVersion());
    }

    @Test
    void getAuthor() {
        assertEquals("Van Eenaeme Kjani", Info.getAuthor());
    }
}