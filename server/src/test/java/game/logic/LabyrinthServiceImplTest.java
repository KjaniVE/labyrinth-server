package game.logic;

import game.logic.player.Player;
import game.web.LabyrinthUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LabyrinthServiceImplTest {

    LabyrinthServiceImpl labyrinthService = new LabyrinthServiceImpl();
    GameId gameId = new GameId("test");
    Player player = new Player(new LabyrinthUser(gameId.toString(), "testPlayer"));

    @Test
    void getTreasures() {
        assertEquals(24, labyrinthService.getTreasures().size());
    }

    @Test
    void createGame() {
        LabyrinthServiceImpl labyrinthService2 = new LabyrinthServiceImpl();
        labyrinthService2.createGame(gameId, player, 2);
        assertEquals(1, labyrinthService2.getGames(true).size());
    }

    @Test
    void noDoubleGameIdGames() {
        labyrinthService.createGame(gameId, player, 2);
        assertThrows(LabyrinthException.class, () -> labyrinthService.createGame(gameId, player, 2));
    }

    @Test
    void JoinGame() {
        LabyrinthServiceImpl labyrinthService2 = new LabyrinthServiceImpl();
        labyrinthService2.createGame(gameId, player, 3);
        Player player2 = new Player(new LabyrinthUser(gameId.toString(), "testPlayer2"));
        labyrinthService2.joinGame(gameId, player2);
        assertEquals(2, labyrinthService2.getGames(true).iterator().next().getPlayers().size());
    }
}