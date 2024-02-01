package hangman;

public class Status {
    public static final String ZERO = """
             ╒══╗
                ║
                ║
                ║
             ═══╩═
            """;
    public static final String ONE = """
             ╒══╗
             O  ║
                ║
                ║
             ═══╩═
            """;
    public static final String TWO = """
             ╒══╗
             O  ║
             |  ║
                ║
             ═══╩═
            """;
    public static final String THREE = """
             ╒══╗
             O  ║
            /|  ║
                ║
             ═══╩═
            """;
    public static final String FOUR = """
             ╒══╗
             O  ║
            /|\\ ║
                ║
             ═══╩═
            """;
    public static final String FIVE = """
             ╒══╗
             O  ║
            /|\\ ║
            /   ║
             ═══╩═
            """;
    public static final String SIX = """
             ╒══╗
             O  ║
            /|\\ ║
            / \\ ║
             ═══╩═
            """;
    public static final String[] STATUSES = {ZERO,ONE,TWO,THREE,FOUR,FIVE,SIX};
}
