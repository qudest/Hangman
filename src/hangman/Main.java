package hangman;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        while (true) {
            getMenu();
        }
    }

    public static void getMenu() {
        Scanner scanner = new Scanner(System.in);
        Menu.printMenu();
        try {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Game game = new Game(new File("words.txt"));
                    game.start();
                    break;
                case 2:
                    System.out.println("Выход");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nПожалуйста, введите пункт меню!");
            }
        } catch (InputMismatchException e) {
            System.out.println("\nПожалуйста, введите пункт меню!");
        }
    }
}