import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Exercise_14 {

    /*
     * public static void readFile(String fileName) {
     * Path filePath = Paths.get(fileName);
     * try {
     * String content = Files.readString(filePath);
     * System.out.println("Content read from the file:");
     * System.out.println(content);
     * } catch (IOException e) {
     * System.out.println("Error reading the file: " + e.getMessage());
     * e.printStackTrace();
     * }
     * }
     * 
     * public static void main(String[] args) {
     * readFile("../docs/GITHUB.txt");
     * }
     */

    public static void readFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        String content = Files.readString(filePath);
        System.out.println("Content read from the file:");
        System.out.println(content);
    }

    public static void main(String[] args) {
        try {
            readFile("../docs/GITHUB.txt");
        } catch( IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }
        
    }
}
