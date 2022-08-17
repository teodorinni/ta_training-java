import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//  4. Прочитать текст Java-программы и в каждом слове длиннее двух символов все строчные символы заменить прописными.
public class ChangeWordsToUppercase {

    private static final String FOLDER_NAME = "change_words_to_uppercase";

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a path to a .java file: ");
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String path = inputReader.readLine();
        File file = new File(path);
        if (file.exists() && file.isFile() && path.endsWith(".java")) {
            String textFromFile = Files.readString(Path.of(path));
            Pattern pattern = Pattern.compile("\\w{2,}");
            Matcher matcher = pattern.matcher(textFromFile);
            String changedText = matcher.replaceAll(words -> words.group().toUpperCase());
            new File(FOLDER_NAME).mkdirs();
            try (FileWriter writer = new FileWriter(FOLDER_NAME +"/changed_"+ file.getName(), true)) {
                // Clear any text from file
                File updatedFile = new File(FOLDER_NAME +"/changed_"+ file.getName());
                PrintWriter printWriter = new PrintWriter(updatedFile);
                printWriter.print("");
                printWriter.close();

                writer.write(changedText);
            }
        } else {
            System.out.println("The path to .java file is incorrect.");
        }
    }
}
