import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//  4. Прочитать текст Java-программы и в каждом слове длиннее двух символов все строчные символы заменить прописными.
public class ChangeWordsToUppercase {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter a path to a .java file: ");
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String path = inputReader.readLine();
        File file = new File(path);
        if (file.exists() && file.isFile() && path.endsWith(".java")) {
            List<String> textFromFileList = new ArrayList<>();
            List<String> changedLines = new ArrayList<>();
            Pattern pattern = Pattern.compile("\\w{2,}");
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    textFromFileList.add(line);
                }
            }
            for (String line : textFromFileList) {
                Matcher matcher = pattern.matcher(line);
                String lineWithUppercase = matcher.replaceAll(m -> m.group().toUpperCase());
                changedLines.add(lineWithUppercase);
            }
            new File("change_words_to_uppercase").mkdirs();
            try (FileWriter writer = new FileWriter("change_words_to_uppercase/changed_"+ file.getName(), true)) {
                // Clear any text from file
                File updatedFile = new File("change_words_to_uppercase/changed_"+ file.getName());
                PrintWriter printWriter = new PrintWriter(updatedFile);
                printWriter.print("");
                printWriter.close();

                for (String line : changedLines) {
                    writer.write(line + "\n");
                }
            }
        } else {
            System.out.println("The path to .java file is incorrect.");
        }
    }
}
