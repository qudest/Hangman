package hangman;

import java.io.*;
import java.util.*;

public class Game {
    private static final String[] MENU = {"1. Начать новую игру",
                                          "2. Выйти из приложения"};

    private static void printMenu() {
        for (String option: Game.MENU) {
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
                    System.out.println("Start");
                    System.out.println(readWords(file));
//                    System.out.println();
//                    for (String status: Status.STATUSES) {
//                        System.out.println(status);
//                        System.out.println();
//                    }
                    break;
                case 2:
                    System.out.println("Выход");
                    break;
            }
        }
    }

    private static void start() {
        Random random = new Random();

    }
}