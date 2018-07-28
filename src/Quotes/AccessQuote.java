//FOLLOWING EXAMPLE FROM CLASS

package Quotes;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class AccessQuote {


    public static String quoteRandomizer() {
        QuotesConstructor quote = null;
        /*
        I followed through the video instructions so I could learn it a little better and I got a null for the body of the quote but it WILL print the author. So I copied and pasted Steve's version from the README and I STILL get a null for the body of the quote.

        EDIT: Never mind. I called the text "textOfQuote" instead of just "text". That made all the difference. Making a note here so I don't do that for other JSON files.
         */

        try {
            Gson gson = new Gson();
            String filepath = "/Users/amycohen/codefellows/401/lab-amy/08-manual-http-json-server/src/recentquotes.json";
            File file = new File(filepath);
            FileReader reader = new FileReader(file);

            QuotesConstructor[] quotes = gson.fromJson(reader, QuotesConstructor[].class);
            System.out.println("Num quotes: " + quotes.length);

            int randomIndex = (int) Math.floor(quotes.length * Math.random());
            quote = quotes[randomIndex];
            System.out.println(quote);
            return String.valueOf(quote);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return String.valueOf(quote);
    }
}
