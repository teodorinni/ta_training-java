import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

//  2. Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.
public class ChangePublicToPrivate {

    private static final String FOLDER_NAME = "change_public_to_private";

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a path to a .java file: ");
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String path = inputReader.readLine();
        File file = new File(path);
        if (file.exists() && file.isFile() && path.endsWith(".java")) {
            String textFromFile = Files.readString(Path.of(path));
            String textChanged = textFromFile.replaceAll("public", "private");
            new File(FOLDER_NAME).mkdirs();
            try (FileWriter writer = new FileWriter(FOLDER_NAME + "/changed_"+ file.getName(), true)) {
                // Clear any text from file
                File updatedFile = new File(FOLDER_NAME + "/changed_"+ file.getName());
                PrintWriter printWriter = new PrintWriter(updatedFile);
                printWriter.print("");
                printWriter.close();

                writer.write(textChanged);
            }
        } else {
            System.out.println("The path to .java file is incorrect.");
        }
    }
}
