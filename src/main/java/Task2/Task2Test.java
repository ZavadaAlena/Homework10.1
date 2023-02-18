package Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;

public class Task2Test {
    public static void main(String[] args) throws IOException {
        List<User> users = new ArrayList<>();
        try (InputStream fis = new FileInputStream("src/main/java/Task2/file2.txt");
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] splitLine = line.split(" ");
                String name = splitLine[0];
                int age;
                try {
                    age = Integer.parseInt(splitLine[1]);
                } catch (NumberFormatException ex) {
                    continue;
                }
                users.add(new User(name, age));

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result = gson.toJson(users);
        System.out.println(result);
        OutputStream fos = new FileOutputStream("src/main/java/Task2/users.json");
        fos.write(result.getBytes());


    }
}
