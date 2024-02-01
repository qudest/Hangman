package hangman;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Game {
    private static final String[] MENU = {"1. Начать новую игру",
            "2. Выйти из приложения"};

    private static void printMenu() {
        for (String option : Game.MENU) {
            System.out.println(option);
        }
        System.out.println();
    }

    private static List<String> readWords(File file) {
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] s = scanner.nextLine().split(" ");
                words.addAll(Arrays.asList(s));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return words;
    }

    public static void main(String[] args) {
        File file = new File("words.txt");
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while (choice != 2) {
            printMenu();
            choice = scanner.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    game(scanner, readWords(file));
                    break;
                case 2:
                    System.out.println("Выход");
                    break;
            }
        }
        scanner.close();
    }

    //todo проброс scanner не очень
    private static void game(Scanner scanner, List<String> words) {
        Random random = new Random();
        String word = words.get(random.nextInt(words.size())).toLowerCase(Locale.ROOT);
        if (win(scanner, word)) {
            System.out.println("Победа! Загаданное слово — " + word);
        } else {
            System.out.println("Поражение! Загаданное слово — " + word);
        }
    }

    public static boolean win(Scanner scanner, String word) {
        int mistakesCounter = 0;
        List<Character> mistakes = new ArrayList<>();
        Set<Character> exist = new HashSet<>();

        while (mistakesCounter < 7) {
            System.out.println(Status.STATUSES[mistakesCounter]);
            System.out.print("Слово: ");
            for (int i = 0; i < word.length(); i++) {
                if (exist.contains(word.charAt(i))) {
                    System.out.print(word.charAt(i) + " ");
                } else {
                    System.out.print("_" + " ");
                }
            }
            System.out.println("\nОшибки (" + mistakesCounter + "): " + mistakes);

            char input;

            if (mistakesCounter != 6) {
                while (true) {
                    System.out.print("Буква: ");
                    input = scanner.next().charAt(0);
                    if (exist.contains(input) || mistakes.contains(input)) {
                        System.out.println("Эта буква уже была!");
                        continue;
                    }
                    break;
                }

                if (word.indexOf(input) != -1) {
                    exist.add(input);
                } else {
                    mistakes.add(input);
                    mistakesCounter++;
                }

                if (exist.size() == countUniqueChars(word)) {
                    System.out.println();
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }

    private static int countUniqueChars(String word) {
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