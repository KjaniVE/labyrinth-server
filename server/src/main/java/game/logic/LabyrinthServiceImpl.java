package game.logic;

import java.util.List;

import static game.logic.Treasures.getAllTreasures;

public class LabyrinthServiceImpl implements LabyrinthService {

    @Override
    public List<String> getTreasures() {
        return getAllTreasures();
    }
}
