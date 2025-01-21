package game.logic.treasure;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;

public class TreasuresUtil {

    private static final SecureRandom random = new SecureRandom();

    protected TreasuresUtil() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    public static List<String> getAllTreasures() {
        List<String> treasures = new LinkedList<>();
        for (Treasures treasure : Treasures.values()) {
            treasures.add(treasure.getName());
        }
        return treasures;
    }

    public static Treasure getRandomTreasure() {
        Treasures[] allTreasures = Treasures.values();
        return allTreasures[random.nextInt(allTreasures.length)].getTreasure();
    }
}
