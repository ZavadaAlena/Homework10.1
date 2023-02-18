package Task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1Test {
    public static void main(String[] args) {
        File file = new File("src/main/java/Task1/file.txt");
        if (file.exists()) {
            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {
                while (scanner.hasNext()) {
                    Pattern pattern = Pattern.compile("^((\\([0-9]{3}\\) )|([0-9]{3}-))[0-9]{3}-[0-9]{4}$");
                    Matcher matcher = pattern.matcher(scanner.nextLine());
                    if (matcher.find()) {
                        System.out.println(matcher.group());
                    }
                }
            } catch (IOException e) {
                e.getStackTrace();
            }

        }
    }


}
