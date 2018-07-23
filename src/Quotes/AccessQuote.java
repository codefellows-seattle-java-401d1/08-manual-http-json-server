package Quotes;

import com.google.gson.Gson;

import java.io.*;


public class AccessQuote {
    public static String generateQuote(){
        Quote randomQuote;
        try {
            Gson gson = new Gson();
            String filepath = "/Users/sooz/codefellows/401Java/Labs/08-manual-http-json-server/mywebsite/recentquotes.json";
            File file = new File(filepath);
            FileReader reader = new FileReader(file);

            Quote[] quotes = gson. fromJson(reader, Quote[].class);
            System.out.println("Num quotes: " + quotes.length);


            int randomIndex = (int)Math.floor(quotes.length * (Math.random()));
            randomQuote = quotes[randomIndex];
            System.out.println(randomQuote);
            return String.valueOf(randomQuote);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return "There you go!";
    }
}
