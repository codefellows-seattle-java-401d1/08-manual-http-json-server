import java.io.File;
import java.util.Scanner;

public class FileMain {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\tbeth\\iCloudDrive\\Desktop\\code-fellows\\java-401d1\\labs\\08-manual-http-json" +
                "-server\\index.html";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}
