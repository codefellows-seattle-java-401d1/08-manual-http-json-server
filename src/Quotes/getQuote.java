package Quotes;
import java.io.*;
import com.google.gson.Gson;

public class getQuote {
    public static String generateQuote() {
        Quote randomQuote;
        try {
            Gson gson = new Gson();
            String filepath = "";
            File file = new File(filepath);
            FileReader reader = new FileReader(file);

            Quote[] quotes = gson.fromJson(reader, Quote[].class);
            System.out.println("quotes: " + quotes.length);

            int random = (int) Math.floor(quotes.length * (Math.random()));
            randomQuote = quotes[random];
            System.out.println(randomQuote);
            return String.valueOf(randomQuote);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "Quote";
    }
}