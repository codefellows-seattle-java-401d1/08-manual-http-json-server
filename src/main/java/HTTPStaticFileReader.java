import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class HTTPStaticFileReader {
    private static final String ABSOLUTE_PATH_QUOTES = "/Users/greg/codefellows/401/labs/08-manual-http-json-server/src/main/resources/recentquotes.json";

    private String path;

    public HTTPStaticFileReader(HTTPRequest request) {
        this.path = request.path;
    }

    public String getContents() throws IOException {
        String result = "";

        String filepath = ABSOLUTE_PATH_QUOTES;
        File file = new File(filepath);
        Scanner scanner = new Scanner(file);
        ArrayList quoteList = new ArrayList<String>();
        Random random = new Random();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            quoteList.add(line);
        }
        result = (String) quoteList.get(random.nextInt(quoteList.size()));
        return getQuoteFromLine(result);
    }

    // accepts a line and either returns the plain line
    // or detects the template syntax {{SYMBOL MARKER}}
    // and replaces that portion of the line with
    // corresponding content.



    private String getQuoteFromLine(String line) {
        if (!line.contains("\"text\": ")) {
            return line;
        }
        String[] cells = line.split("u201c");
        String rest = cells[1];

        cells = rest.split("\\\\u201d");

        return cells[0];
    }


    public String currentTimeStamp() {
        Date date = new Date();
        return date.toString();
    }
}

