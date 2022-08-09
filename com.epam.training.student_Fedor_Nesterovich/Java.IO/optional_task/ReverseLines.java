import java.io.*;
import java.util.ArrayList;
import java.util.List;

//  3. Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.
public class ReverseLines {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter a path to a .java file: ");
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String path = inputReader.readLine();
        File file = new File(path);
        if (file.exists() && file.isFile() && path.endsWith(".java")) {
            List<String> textFromFileList = new ArrayList<>();
            List<String> reverseLines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    textFromFileList.add(line);
                }
            }
            textFromFileList.forEach(line -> reverseLines.add(new StringBuilder(line).reverse().toString()));
            new File("reverse_lines").mkdirs();
            try (FileWriter writer = new FileWriter("reverse_lines/changed_"+ file.getName(), true)) {
                // Clear any text from file
                File updatedFile = new File("reverse_lines/changed_"+ file.getName());
                PrintWriter printWriter = new PrintWriter(updatedFile);
                printWriter.print("");
                printWriter.close();

                for (String line : reverseLines) {
                    writer.write(line + "\n");
                }
            }
        } else {
            System.out.println("The path to .java file is incorrect.");
        }
    }
}
