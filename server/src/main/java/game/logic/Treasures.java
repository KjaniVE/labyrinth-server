package game.logic;

import java.util.LinkedList;
import java.util.List;

public class Treasures {

    private static final Treasure[] ALL_TREASURES = {
            new Treasure("Bag of Gold Coins"),
            new Treasure("Bat"),
            new Treasure("Book with Clasp"),
            new Treasure("Dragon"),
            new Treasure("Ghost (in bottle)"),
            new Treasure("Ghost (waving)"),
            new Treasure("Gold Crown"),
            new Treasure("Gold Menorah"),
            new Treasure("Gold Ring"),
            new Treasure("Helmet (armor)"),
            new Treasure("Jewel"),
            new Treasure("Lady Pig"),
            new Treasure("Lizard"),
            new Treasure("Moth"),
            new Treasure("Owl"),
            new Treasure("Rat"),
            new Treasure("Scarab"),
            new Treasure("Set of Keys"),
            new Treasure("Skull"),
            new Treasure("Sorceress"),
            new Treasure("Spider on Web"),
            new Treasure("Sword"),
            new Treasure("Treasure Chest"),
            new Treasure("Treasure Map")
    };

    protected Treasures() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    public static List<String> getAllTreasures() {
        List<String> treasures = new LinkedList<>();
        for (Treasure treasure : ALL_TREASURES) {
            treasures.add(treasure.getName());
        }
        return treasures;
    }
}
