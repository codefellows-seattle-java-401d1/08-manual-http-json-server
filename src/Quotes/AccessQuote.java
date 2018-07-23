package Quotes;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

    public class AccessQuote {

        public static String assignQuote() {
            Quote randomQuote;
            try {
                Gson gson = new Gson();
                String filepath = "/Users/macbookpro-2/Desktop/401/08-manual-http-json-server/recentquotes.json";
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
            return "Delivered";
        }
    }