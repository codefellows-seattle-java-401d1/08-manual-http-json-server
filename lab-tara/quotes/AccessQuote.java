package quotes;

import com.google.gson.Gson;

import java.io.*;

public class AccessQuote {
    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            String filepath = "C:\\Users\\tbeth\\iCloudDrive\\Desktop\\code-fellows\\java-401d1\\labs\\08-manual-http" +
                    "-json-server\\lab-tara\\recentquotes.json";
            File file = new File(filepath);
            FileReader reader = new FileReader(file);

            Quote[] quotes = gson.fromJson(reader, Quote[].class);

            System.out.println("Num quotes: " + quotes.length);

            int randomIndex = (int) Math.floor(quotes.length * Math.random());
            Quote quote = quotes[randomIndex];
            System.out.println(quote);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}