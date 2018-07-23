package SimpleManualHTTPServer;

import Quotes.AccessQuote;
import Quotes.Quote;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Scanner;

//needs access to HTTP Request object and use it to find the path of the requested file, read the file content and
// then format a HTTP response with the file contents
public class HTTPStaticFileReader {
    private static final String ROOT_PATH_PREFIX =
            "/Users/sooz/codefellows/401Java/Labs/08-manual-http-json-server/mywebsite/";
    private  String path;

    public HTTPStaticFileReader(HTTPRequest request){
        this.path = request.path;
    }

    public String getContents() throws IOException{
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

    //accepts a line and either returns the plain line, or
    //detects the template syntax {{SYMBOL_MARKER}} and replaces that portion
    //of the line with corresponding content for "SYMBOL_MARKER"
    private String processLine(String line) {
        if (!line.contains("{{")) {
            return line;
        }
        //"<p>{{RANDOM_JSON_QUOTE}}<p>"
        // first "<p>"
        //rest "RANDOM_JSON_QUOTE</p>"
        String[] cells = line.split("\\{\\{");
        String first = cells[0];
        String rest = cells[1];

        cells = rest.split("}}");
        String symbol = cells [0];
        String last = cells [1];

        String content ="___";

        if(symbol.equals("RANDOM_JSON_QUOTE")){
            content = AccessQuote.generateQuote();
        } else if(symbol.equals("TIMESTAMP")){
            content = currentTimestamp();
        } else{
            content = randomJSONQuote();
        }
        return first + content + last;
    }

    public String randomJSONQuote(){
        return "\"Our prime purpose in this life is to help others. And if you can't help them, at least don't hurt " +
                "them.\n - 14th Dalai Lama";
    }

    public String currentTimestamp(){
        Date date = new Date();
        return  date.toString();
    }
}
