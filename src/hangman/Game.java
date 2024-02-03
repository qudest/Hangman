package hangman;

import java.io.File;
import java.util.*;

public class Game {
    private static final String GAME_STATE_WIN = "Победа! Загаданное слово — ";
    private static final String GAME_STATE_DEFEAT = "Поражение! Загаданное слово — ";
    private final Scanner scanner = new Scanner(System.in);
    private final List<Character> mistakes = new ArrayList<>();
    private final Set<Character> guessed = new HashSet<>();
    private final String word;

    public Game(File fileWithWords) {
        List<String> words = Reader.readWords(fileWithWords);
        Random random = new Random();
        this.word = words.get(random.nextInt(words.size())).toLowerCase();
    }

    public void start() {
        System.out.println("\n" + startGameLoop() + word + "\n");
    }

    private String startGameLoop() {
        while (mistakes.size() < GallowsStatuses.STATUSES.length-1) {
            System.out.println();
            printGameState();

            char input = inputLetter();

            if (word.indexOf(input) != -1) {
                guessed.add(input);
            } else {
                mistakes.add(input);
            }

            if (guessed.size() == countUniqueChars(word)) {
                System.out.println();
                printGameState();
                return GAME_STATE_WIN;
            }
        }
        System.out.println();
        printGameState();

        return GAME_STATE_DEFEAT;
    }

    private char inputLetter() {
        char input;
        do {
            System.out.print("Буква: ");
            input = scanner.next().toLowerCase().charAt(0);
            if (validateInput(input)) {
                return input;
            }
        } while (true);
    }

    private boolean validateInput(char input) {
        if (!isRusLetter(input)) {
            System.out.println("Можно вводить только буквы кириллицы!");
            return false;
        }
        if (isInputted(input)) {
            System.out.println("Эта буква уже была!");
            return false;
        }
        return true;
    }

    private void printGameState() {
        System.out.print(GallowsStatuses.STATUSES[mistakes.size()]);
        System.out.print("Слово: ");
        for (int i = 0; i < word.length(); i++) {
            System.out.print(isGuessed(word.charAt(i)) + " ");
        }
        System.out.println("\nОшибки (" + mistakes.size() + "): " + mistakes);
    }

    private char isGuessed(char symbol) {
        if (guessed.contains(symbol)) {
            return symbol;
        }
        return '_';
    }

    private boolean isInputted(char symbol) {
        return guessed.contains(symbol) || mistakes.contains(symbol);
    }

    private boolean isRusLetter(char symbol) {
        return Character.isLetter(symbol) && Character.UnicodeBlock.CYRILLIC.equals(Character.UnicodeBlock.of(symbol));
    }

    private int countUniqueChars(String word) {
        Set<Character> unique = new HashSet<>();
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            if (!unique.contains(word.charAt(i))) {
                counter++;
            }
            unique.add(word.charAt(i));
        }
        return counter;
    }
}
