package Task3;

import java.io.*;
import java.util.*;

public class Task3Test {
    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<>();
        try (InputStream fis = new FileInputStream("src/main/java/Task3/words.txt");
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] splitLine = line.split(" ");
                for (String word : splitLine) {
                    if (words.containsKey(word)) {
                        int currValue = words.get(word);
                        words.put(word, currValue + 1);
                    } else {
                        words.put(word, 1);
                    }
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return words.get(o1).compareTo(words.get(o2)) > 0 ? 1 : -1;

            }
        };

        Map<String, Integer> result = new TreeMap<>(comparator.reversed());
        result.putAll(words);
        System.out.println(result);
    }

}
