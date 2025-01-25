package game.logic;

public class Info {

    private static final String VERSION = "v0.0.1";

    private static final String AUTHOR = "Van Eenaeme Kjani";

    protected Info () {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    public static String getVersion() {
        return VERSION;
    }

    public static String getAuthor() {
        return AUTHOR;
    }
}
