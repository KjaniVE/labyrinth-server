package game.logic.maze;

import game.logic.Direction;
import game.logic.Location;
import game.logic.maze.tile.Tile;
import game.logic.maze.tile.Wall;
import game.logic.treasure.Treasure;
import game.logic.treasure.TreasuresUtil;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Maze {

    private static final SecureRandom random = new SecureRandom();
    private static final int BOARD_SIZE = 7;
    private static final int NUMBER_OF_TILES = BOARD_SIZE * BOARD_SIZE;

    private final Set<Treasure> usedTreasures = new HashSet<>();
    private final Map<Location, Tile> board = new HashMap<>();

    public Map<Location, Tile> getBoard() {
        return board;
    }

    public Maze() {
        Set<Integer> tilesWithTreasures = determineTilesWithTreasures();
        initializeBoard(tilesWithTreasures);
    }

    private void initializeBoard(Set<Integer> tilesWithTreasures) {
    for (int i = 0; i < BOARD_SIZE; i++) {
        for (int j = 0; j < BOARD_SIZE; j++) {
            Location location = new Location(i, j);
            Treasure treasure = tilesWithTreasures.contains(i * BOARD_SIZE + j) ? getRandomTreasure() : null;
            addTileToMaze(location, treasure);
        }
    }
}

    private void addTileToMaze(Location location, Treasure treasure) {
        Map<Direction, Wall> walls = Position.getWallsForPosition(location);
        board.put(location, new Tile(treasure, walls));
    }

    private Set<Integer> determineTilesWithTreasures() {
        Set<Integer> tilesWithTreasures = new HashSet<>();
        while (tilesWithTreasures.size() < TreasuresUtil.getAllTreasures().size()) {
            tilesWithTreasures.add(random.nextInt(NUMBER_OF_TILES));
        }
        return tilesWithTreasures;
    }

    private Treasure getRandomTreasure() {
        Treasure treasure = TreasuresUtil.getRandomTreasure();
        if (usedTreasures.contains(treasure)) {
            return getRandomTreasure();
        }
        usedTreasures.add(treasure);
        return treasure;
    }

}
