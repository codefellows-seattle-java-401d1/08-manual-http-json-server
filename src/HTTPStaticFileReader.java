import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HTTPStaticFileReader {
    private  static  final String ROOT_PATH_PREFIX = "/Users/paulsuarez/codefellowsprojects/401/08-manual-http-json-server/src/mywebsite/";
    private String path;

    public HTTPStaticFileReader(HTTPRequest request) {
        this.path = request.path;
    }

    public String getContents() throws IOException {
        String result = "";

        String filepath = ROOT_PATH_PREFIX + this.path;
        File file = new File(filepath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            result += processLine(line);
        }
        return result;
    }




    private String processLine(String line) {
        if (!line.contains("{{")) {
            return line;
        }




        String[] cells = line.split("\\{\\{");
        String first = cells[0];
        String rest = cells[1];

        cells = rest.split("\\}\\}");
        String symbol = cells[0];
        String last = cells[1];

        String content = "";
        if (symbol.equals("RANDOM_JSON_QUOTE")) {
            content = randomJSONQuote();
        }

        return first + content + last;
    }

    public String randomJSONQuote() {
        return "\"This is my famous quote.\" --Suarez";
    }
}
