package game.logic;

import game.web.LabyrinthUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    LabyrinthUser user = new LabyrinthUser("gameId", "test");
    Player player = new Player(user);

    @Test
    void testPlayerStatus() {
        assertEquals(PlayerStatus.WAITING, player.getState(), "Player status should be WAITING");
        player.setState(PlayerStatus.PLAYING);
        assertEquals(PlayerStatus.PLAYING, player.getState(), "Player status should be PLAYING");
    }

    // Test if the player can have another objective
    @Test
    void testObjective() {
        Treasure diamond = new Treasure("DIAMOND");
        Treasure gold = new Treasure("GOLD");
        player.setObjective(diamond);
        assertEquals(diamond, player.getObjective(), "Player objective should be DIAMOND");
        player.setObjective(gold);
        assertEquals(gold, player.getObjective(), "Player objective should be GOLD");
    }
}
