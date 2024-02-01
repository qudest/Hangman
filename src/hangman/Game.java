package hangman;

import java.util.Scanner;

public class Game {
    private static final String[] MENU = {"1. Начать новую игру",
                                          "2. Выйти из приложения"};

    private static void printMenu() {
        for (String option: Game.MENU) {
            System.out.println(option);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while (choice != 2) {
            printMenu();
            choice = scanner.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    System.out.println("Start");
                    System.out.println();
                    for (String status: Status.STATUSES) {
                        System.out.println(status);
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Выход");
                    break;
            }
        }
    }
}