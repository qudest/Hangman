package hangman;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Reader {
    public static List<String> readWords(File file) {
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
}
