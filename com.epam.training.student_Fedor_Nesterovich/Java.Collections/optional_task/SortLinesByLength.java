import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

// 4.   Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
public class SortLinesByLength {

    public static void main(String[] args) {
        sortLinesByLength("sort_lines_by_length.txt");
    }

    public static void sortLinesByLength(String filePath) {
        try {
            List<String> stringList;
            stringList = Files.readAllLines(Path.of(filePath), StandardCharsets.UTF_8);
            stringList.sort(Comparator.comparing(String::length));
            System.out.println("Modified verse:");
            for (String line : stringList) {
                System.out.println(line);
            }
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
