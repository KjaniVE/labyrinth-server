package game;

import game.logic.player.Player;
import game.web.LabyrinthUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Player player = new Player(new LabyrinthUser("test", "test"));
    Game game = new Game(player.getUser().getGameId(), 2, player);

    @Test
    void getId() {
        assertEquals(player.getUser().getGameId(), game.getId());
    }

    @Test
    void getMaze() {
        assertNotNull(game.getMaze());
    }

    @Test
    void getPlayers() {
        assertEquals(1, game.getPlayers().size());
    }

    @Test
    void getMaxPlayers() {
        assertEquals(2, game.getMaxPlayers());
    }
}