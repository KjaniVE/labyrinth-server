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

    @Test
    void testTreasureFound() {
        assertEquals(0, player.getTreasuresFound().size(), "Player should have found 0 treasures");
    }

    @Test
    void getUser() {
        assertEquals(user, player.getUser(), "Player should have the same user");
        assertEquals(user.getPlayerName(), player.getUser().getPlayerName(), "Playername should be test");
        assertEquals(user.getGameId(), player.getUser().getGameId(), "Player gameId should be gameId");
    }
}
