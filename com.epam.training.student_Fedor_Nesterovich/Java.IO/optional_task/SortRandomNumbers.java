import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//  1. Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.
public class SortRandomNumbers {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter an amount of randomly generated numbers (should be an Integer > 1): ");
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String input = inputReader.readLine();
        try {
            int numbersAmount = Integer.parseInt(input);
            if (numbersAmount <= 0) {
                throw new NumberFormatException();
            } else {
                List<Integer> numbersList = new ArrayList<>();
                for (int i = 0; i < numbersAmount; i++) {
                    Random random = new Random();
                    numbersList.add(random.nextInt(0, 100));
                }
                new File("sort_random_numbers").mkdirs();
                try (FileWriter writer = new FileWriter("sort_random_numbers/unsorted_numbers.txt", true)) {
                    // Clear any text from file
                    File file = new File("sort_random_numbers/unsorted_numbers.txt");
                    PrintWriter printWriter = new PrintWriter(file);
                    printWriter.print("");
                    printWriter.close();

                    for (int number : numbersList) {
                        writer.write(number +"\n");
                    }
                }
                List<Integer> sortedNumbersList = new ArrayList<>();
                try (BufferedReader reader = new BufferedReader(new FileReader("sort_random_numbers/unsorted_numbers.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        int number = Integer.parseInt(line);
                        sortedNumbersList.add(number);
                    }
                    sortedNumbersList.sort(Integer::compare);
                }
                try (FileWriter writer = new FileWriter("sort_random_numbers/sorted_numbers.txt", true)) {
                    // Clear any text from file
                    File file = new File("sort_random_numbers/sorted_numbers.txt");
                    PrintWriter printWriter = new PrintWriter(file);
                    printWriter.print("");
                    printWriter.close();

                    for (int number : sortedNumbersList) {
                        writer.write(number + "\n");
                    }
                }
            }
        } catch (NumberFormatException exception) {
            System.out.println("Incorrect input.");
        }
    }
}
