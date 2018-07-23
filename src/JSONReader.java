
import Quotes.AccessQuote;
import Quotes.Quote;
import com.google.gson.Gson;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class JSONReader {
    public static void main(String[] args) {
    }

    public static void readJson() throws FileNotFoundException {
        Gson gson = new Gson();
        String filename = "/Users/sooz/codefellows/401Java/Labs/08-manual-http-json-server/mywebsite/recentquotes.json";
        InputStream file = new FileInputStream(filename);
        String json = gson.toJson(file);
        System.out.println(json);

        Quote newQuote = new Quote();
        AccessQuote access = new AccessQuote();

        Quote deconstructed = gson.fromJson(json, Quote.class);
        System.out.println(deconstructed.text);
        System.out.println(deconstructed.author);
        System.out.println(Arrays.toString(new String[]{deconstructed.author}));



    }


}
