import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

//  1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
public class LinesInReverseOrder {

    public static void main(String[] args) {
        linesInReverseOrder("lines_in_reverse_order.txt");
    }

    public static void linesInReverseOrder(String filePath) {
        try {
            List<String> stringList;
            stringList = Files.readAllLines(Path.of(filePath), StandardCharsets.UTF_8);
            Collections.reverse(stringList);
            FileWriter writer = new FileWriter(filePath);
            for (String line : stringList) {
                writer.write(line + System.lineSeparator());
            }
            writer.close();
            System.out.println("The file " + filePath + " has been successfully modified.");
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
