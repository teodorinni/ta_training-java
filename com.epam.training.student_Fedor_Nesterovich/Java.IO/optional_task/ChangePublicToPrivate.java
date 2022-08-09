import java.io.*;
import java.util.ArrayList;
import java.util.List;

//  2. Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.
public class ChangePublicToPrivate {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter a path to a .java file: ");
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String path = inputReader.readLine();
        File file = new File(path);
        if (file.exists() && file.isFile() && path.endsWith(".java")) {
            List<String> textFromFileList = new ArrayList<>();
            List<String> updatedTextList = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    textFromFileList.add(line);
                }
            }
            textFromFileList.forEach(line -> updatedTextList.add(line.replaceAll("public", "private")));
            new File("change_public_to_private").mkdirs();
            try (FileWriter writer = new FileWriter("change_public_to_private/changed_"+ file.getName(), true)) {
                // Clear any text from file
                File updatedFile = new File("change_public_to_private/changed_"+ file.getName());
                PrintWriter printWriter = new PrintWriter(updatedFile);
                printWriter.print("");
                printWriter.close();

                for (String line : updatedTextList) {
                    writer.write(line + "\n");
                }
            }
        } else {
            System.out.println("The path to .java file is incorrect.");
        }
    }
}
