//FOLLOWING EXAMPLE FROM CLASS

package Quotes;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class AccessQuote {
    public static void main(String[] args) {


        try {
            Gson gson = new Gson();
            String filepath = "/Users/amycohen/codefellows/401/lab-amy/08-manual-http-json-server/src/recentquotes.json";
            File file = new File(filepath);
            FileReader reader = new FileReader(file);
            QuotesConstructor[] quoteReader = gson.fromJson(reader, QuotesConstructor[].class);
            System.out.println("Number of quotes = " + quoteReader.length);

            int randomQuoteGenerator = (int)Math.floor(Math.random() * quoteReader.length);
            QuotesConstructor quoteGenerator = quoteReader[randomQuoteGenerator];
            System.out.println(quoteGenerator);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
