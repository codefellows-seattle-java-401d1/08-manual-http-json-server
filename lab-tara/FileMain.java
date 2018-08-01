import java.io.File;
import java.util.Scanner;

public class FileMain {
    public static void main(String[] args) throws Exception {
        String path = "/Users/tara/Desktop/code-fellows/java-401d1/labs/08-manual-http-json-server/recentquotes.json";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}