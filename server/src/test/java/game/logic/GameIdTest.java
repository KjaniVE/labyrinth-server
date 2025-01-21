package game.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameIdTest {

    @Test
    void testGameIdsFromTheSameStringAreEqual(){
        GameId id1 = new GameId("test");
        GameId id2 = new GameId("test");
        assertEquals(id1, id2);
    }

}
