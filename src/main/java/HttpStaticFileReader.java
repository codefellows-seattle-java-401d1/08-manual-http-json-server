package main.java;
import com.google.gson.stream.JsonReader;
import Quotes.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class HttpStaticFileReader {
    private static final String File_PATH =
            "/Users/ahmedosman/Desktop/401/labs/lab8-ahmed/08-manual-http-json-server/recentquotes.json";
    private  String path;

    public HTTPStaticFileReader(HttpRequest request){
        this.path = request.path;
    }
    public String getContents() throws IOException{
        String result = "";

        String filepath = File_PATH + this.path;
        File file = new File(filepath);
        Scanner userInput = new Scanner(file);
        while (userInput.hasNextLine()) {
            String line = userInput.nextLine();
            result += getLine(line);
        }
        return result;
    }
    private String getLine(String line) {
        if (!line.contains("{{")) {
            return line;
        }
        String[] cells = line.split("\\{\\{");
        String first = cells[0];
        String second = cells[1];

        cells = second.split("}}");
        String type = cells [0];
        String last = cells [1];

        String content ="";

        if(type.equals("RANDOM_JSON_QUOTE")){
            content = getQuote.generateQuote();
        } else if(type.equals("TIMESTAMP")){
            content += currentTimestamp();
        } else{
            content += randomJSONQuote();
        }
        return first + content + last;
    }
    public String currentTimestamp(){
        Date date = new Date();
        return  date.toString();
    }

    public String randomJSONQuote(){
        return "";
    }
}
