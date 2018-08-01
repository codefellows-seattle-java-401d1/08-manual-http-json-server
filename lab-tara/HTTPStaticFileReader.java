import quotes.AccessQuote;
import quotes.Quote;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class HTTPStaticFileReader {
    private static final String ROOT_PATH_PREFIX =
            "/Users/tara/Desktop/code-fellows/java-401d1/labs/08-manual-http-json-server/lab-tara/html/";
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

    // Accepts a line and either returns the plain line, or
    // detects the template syntax {{SYMBOL_MARKER}} and replaces that portion
    // of the line with corresponding content for "SYMBOL_MARKER"
    private String processLine(String line) {
        if (!line.contains("{{")) {
            return line;
        }

        // "<p>{{RANDOM_JSON_QUOTE}}</p>"
        // first "<p>"
        // rest RANDOM_JSON_QUOTE}}</p>"
        String[] cells = line.split("\\{\\{");
        String first = cells[0];
        String rest = cells[1];

        cells = rest.split("\\}\\}");
        String symbol = cells[0];
        String last = cells[1];

        String content = "";
        if (symbol.equals("RANDOM_JSON_QUOTE")) {
            content = String.valueOf(AccessQuote.renderQuote());
//            content = randomJSONQuote();
        } else if (symbol.equals("TIMESTAMP")) {
            content = currentTimeStamp();
        } else {
            content = randomJSONQuote();
        }
        return first + content + last;
    }

    public String randomJSONQuote() {
        return "\"I am not a crook.\" --Nixon";
    }

    public String currentTimeStamp() {
        Date date = new Date();
        return date.toString();
    }
}