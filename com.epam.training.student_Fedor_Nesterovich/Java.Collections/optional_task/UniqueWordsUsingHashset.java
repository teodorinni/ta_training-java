import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

//  8. Задан файл с текстом на английском языке. Выделить все различные слова. Слова, отличающиеся только регистром букв, считать одинаковыми. Использовать класс HashSet.
public class UniqueWordsUsingHashset {
    public static void main(String[] args) {
        uniqueWordsUsingHashset("unique_words_using_hashset.txt");
    }

    public static void uniqueWordsUsingHashset(String filePath) {
        try {
            String text;
            text = Files.readString(Path.of(filePath), StandardCharsets.UTF_8).toLowerCase();
            text = text.replaceAll("[^a-zA-Z'’ \n]", "");
            String[] wordsArray = text.split("[ \n]");
            List<String> wordsList= new ArrayList<>(Arrays.asList(wordsArray));
            HashSet<String> wordsSet = new HashSet<>(wordsList);
            System.out.print("Unique words in " + filePath + " file: ");
            System.out.println(wordsSet);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
