import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        List<Word> words = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] inputWords = line.toLowerCase().split("\\s+");
            for (String inputWord : inputWords) {
                Optional<Word> existingWord = words.stream().filter(w -> w.text.equals(inputWord)).findFirst();
                if (existingWord.isPresent()) {
                    existingWord.get().incrementCount();
                } else {
                    words.add(new Word(inputWord));
                }
            }
        }

        // Print Listing 1
        for (Word word : words) {
            System.out.println(word.text + " " + word.count);
        }

        System.out.println();

        // Print Listing 2
        words.sort((w1, w2) -> {
            if (w1.count != w2.count) {
                return w2.count - w1.count;
            } else {
                return w1.text.compareTo(w2.text);
            }
        });

        for (Word word : words) {
            System.out.println(word.text + " " + word.count);
        }
    }
}