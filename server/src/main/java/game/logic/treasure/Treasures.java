package game.logic.treasure;

public enum Treasures {
    BAG_OF_GOLD_COINS(new Treasure("Bag of Gold Coins")),
    BAT(new Treasure("Bat")),
    BOOK_WITH_CLASP(new Treasure("Book with Clasp")),
    DRAGON(new Treasure("Dragon")),
    GHOST_IN_BOTTLE(new Treasure("Ghost (in bottle)")),
    GHOST_WAVING(new Treasure("Ghost (waving)")),
    GOLD_CROWN(new Treasure("Gold Crown")),
    GOLD_MENORAH(new Treasure("Gold Menorah")),
    GOLD_RING(new Treasure("Gold Ring")),
    HELMET_ARMOR(new Treasure("Helmet (armor)")),
    JEWEL(new Treasure("Jewel")),
    LADY_PIG(new Treasure("Lady Pig")),
    LIZARD(new Treasure("Lizard")),
    MOTH(new Treasure("Moth")),
    OWL(new Treasure("Owl")),
    RAT(new Treasure("Rat")),
    SCARAB(new Treasure("Scarab")),
    SET_OF_KEYS(new Treasure("Set of Keys")),
    SKULL(new Treasure("Skull")),
    SORCERESS(new Treasure("Sorceress")),
    SPIDER_ON_WEB(new Treasure("Spider on Web")),
    SWORD(new Treasure("Sword")),
    TREASURE_CHEST(new Treasure("Treasure Chest")),
    TREASURE_MAP(new Treasure("Treasure Map"));

    private final Treasure treasure;

    Treasures(Treasure treasure) {
        this.treasure = treasure;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public String getName() {
        return treasure.getName();
    }
}
