package hangman;

public class Menu {

    private static final String[] MENU = {"1. Начать новую игру",
                                          "2. Выйти из приложения"};
    public static void printMenu() {
        for (String option : MENU) {
            System.out.println(option);
        }
        System.out.println();
    }
}
