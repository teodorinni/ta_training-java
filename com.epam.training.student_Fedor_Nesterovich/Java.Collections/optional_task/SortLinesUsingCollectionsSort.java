import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 6. Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections.
public class SortLinesUsingCollectionsSort {

    public static void main(String[] args) {
        sortLinesUsingCollectionsSort("sort_lines_using_collections_sort.txt");
    }

    public static void sortLinesUsingCollectionsSort(String filePath) {
        try {
            List<String> stringList;
            stringList = Files.readAllLines(Path.of(filePath), StandardCharsets.UTF_8);
            Collections.sort(stringList, Comparator.naturalOrder());
            System.out.println("Modified text:");
            for (String line : stringList) {
                System.out.println(line);
            }
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
