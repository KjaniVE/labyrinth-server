package game.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LabyrinthServiceImplTest {

    @Test
    void getTreasures() {
        LabyrinthServiceImpl labyrinthService = new LabyrinthServiceImpl();
        assertEquals(24, labyrinthService.getTreasures().size());
    }
}