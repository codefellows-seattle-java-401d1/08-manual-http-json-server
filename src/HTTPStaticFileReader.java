import Quotes.AccessQuote;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HTTPStaticFileReader {
    private final String PATH = "/Users/macbookpro-2/Desktop/401/08-manual-http-json-server/mywebsite";
    private String path;

    public HTTPStaticFileReader(HTTPRequest req) {
        this.path = req.path;
    }

    public String contentReader() throws IOException {
        String content= "";

        String filepath = PATH + this.path;
        File pathFile = new File(filepath);
        Scanner filescanner = new Scanner(pathFile);
        while (filescanner.hasNextLine()) {
            String readline = filescanner.nextLine();
            content += parseLine(readline);
        }
        return content;
    }

    private String parseLine(String scanline) {
        if (!scanline.contains("{{")) {
            return scanline;
        }
        String[] arrayOfScanLine = scanline.split("\\{\\{");
        String head = arrayOfScanLine[0];
        String tail = arrayOfScanLine[1];
        arrayOfScanLine = tail.split("\\}\\}");
        String template = arrayOfScanLine[0];
        String end = arrayOfScanLine[1];
        String holder = "";
        if (template.equals("RANDOM_JSON_QUOTE")) {
            holder = AccessQuote.assignQuote();
        } else {
            holder = randomJSONQuote();
        }
        return head + holder + end;
    }

    public String randomJSONQuote(){
        return "\"I'd rather die on my feet, than live on my knees." +
                "\n - Emiliano Zapata";
    }


}
}
