package game.logic;

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

    @Test
    void joinGame() {
        Player player2 = new Player(new LabyrinthUser("test2", "test2"));
        game.joinGame(player2);
        assertEquals(2, game.getPlayers().size());
    }

    @Test
    void playerCanOnlyJoinOnce() {
        Player player2 = new Player(new LabyrinthUser("test2", "test2"));
        game.joinGame(player2);
        game.joinGame(player2);
        assertEquals(2, game.getPlayers().size());
    }

    @Test
    void playerCannotJoinWhenGameIsFull() {
        Player player2 = new Player(new LabyrinthUser("test2", "test2"));
        Player player3 = new Player(new LabyrinthUser("test3", "test3"));
        game.joinGame(player2);
        game.joinGame(player3);
        assertEquals(2, game.getPlayers().size());
    }
}