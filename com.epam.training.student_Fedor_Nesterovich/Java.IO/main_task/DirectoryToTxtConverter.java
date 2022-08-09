import exceptions.FileExtensionException;
import exceptions.IncorrectTxtFileContentsException;
import exceptions.PathException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DirectoryToTxtConverter {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new PathException("The directory path or path to a txt file has not been entered.");
        } else {
            String path = args[0];
            File fileOrDirectory = new File(path);
            if (!fileOrDirectory.exists()) {
                throw new PathException("The directory path or path to a txt file is not valid.");
            } else {
                if (fileOrDirectory.isDirectory()) {
                    pathToTxt(path, 0);
                } else if (fileOrDirectory.isFile() && (path.endsWith(".txt"))) {
                    txtDirectoryStats(path);
                } else {
                    throw new FileExtensionException("The file has an unsupported extension (not .txt)");
                }
            }
        }
    }

    public static void pathToTxt(String path, int currentDirLevel) throws IOException {
        File baseDir = new File(path);
        if (currentDirLevel == 0) {
            try (FileWriter writer = new FileWriter("out/folder_structure.txt")) {
                writer.write(baseDir.getName() + "\n");
                System.out.print(baseDir.getName() + "\n");
            }
            pathToTxt(path, 1);
        } else {
            try {
                for (File fileOrDir : Objects.requireNonNull(baseDir.listFiles())) {
                    if (fileOrDir.isDirectory()) {
                        try (FileWriter writer = new FileWriter("out/folder_structure.txt", true)) {
                            writer.write("    ".repeat(Math.max(0, currentDirLevel - 1)) + "|" + "----" + fileOrDir.getName() + "\n");
                            System.out.print("    ".repeat(Math.max(0, currentDirLevel - 1)) + "|" + "----" + fileOrDir.getName() + "\n");
                        }
                        pathToTxt(fileOrDir.getPath(), currentDirLevel + 1);
                    } else {
                        try (FileWriter writer = new FileWriter("out/folder_structure.txt", true)) {
                            writer.write("    ".repeat(Math.max(0, currentDirLevel - 1)) + "|" + "    " + fileOrDir.getName() + "\n");
                            System.out.print("    ".repeat(Math.max(0, currentDirLevel - 1)) + "|" + "    " + fileOrDir.getName() + "\n");
                        }
                    }
                }
            } catch (NullPointerException ignored) {}
        }
    }

    public static void txtDirectoryStats(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line = null;
            int lineNumber = 1;
            String folderName = null;
            int foldersAmount = 1;
            int filesAmount = 0;
            List<String> filesNames = new ArrayList<>();
            String regexFileName = "^\s*[|{1}]\s{4}[^?/\\\\:*\"<>|\s]+[^?/\\\\:*\"<>|]*[^?/\\\\:*\"<>|.\s]$";
            String regexFolderName = "^\s*[|{1}]-{4}[^?/\\\\:*\"<>|\s]+[^?/\\\\:*\"<>|]*[^?/\\\\:*\"<>|.\s]$";
            Pattern patternFileName = Pattern.compile(regexFileName, Pattern.CASE_INSENSITIVE);
            Pattern patternFolderName = Pattern.compile(regexFolderName, Pattern.CASE_INSENSITIVE);
            while ((line = reader.readLine()) != null) {
                if (lineNumber == 1) {
                    folderName = line;
                    Pattern patternDirectoryName = Pattern.compile("^[^?/\\\\:*\"<>|\s]+[^?/\\\\:*\"<>|]*[^?/\\\\:*\"<>|.\s]$", Pattern.CASE_INSENSITIVE);
                    Matcher matcherDirectoryName = patternDirectoryName.matcher(folderName);
                    boolean correctDirectoryName = matcherDirectoryName.find();
                    if (correctDirectoryName) {
                        lineNumber++;
                    } else {
                        throw new IncorrectTxtFileContentsException("The .txt file does not contain folder structure in correct format.");
                    }
                } else {
                    Matcher matcherFileName = patternFileName.matcher(line);
                    Matcher matcherFolderName = patternFolderName.matcher(line);
                    boolean isFileName = matcherFileName.find();
                    boolean isFolderName = matcherFolderName.find();
                    if (isFolderName) {
                        foldersAmount++;
                    } else if (isFileName) {
                        filesAmount++;
                        String fileName = line.replaceAll("[|\s]", "");
                        filesNames.add(fileName);
                    } else {
                        throw new IncorrectTxtFileContentsException("The .txt file does not contain folder structure in correct format.");
                    }
                }
            }
            if (folderName == null) {
                throw new IncorrectTxtFileContentsException("The .txt file does not contain folder structure in correct format.");
            } else {
                double averageFileNameLength = filesNames.stream().mapToDouble(String::length).average().orElse(0);
                System.out.println("Folder: " + folderName);
                System.out.println("Folders inside the current folder: " + (foldersAmount - 1));
                System.out.println("Average amount of files inside folders: " + (filesAmount / foldersAmount));
                System.out.println("Average file name length: " + averageFileNameLength);
            }
        } catch (IOException ignored) {}
    }
}
