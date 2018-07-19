package Quotes;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AccessQuote {

    public static void main(String[] args) {
        Gson gson = new Gson();

        try {
            String filepath = "recentquotes.json";
            File file = new File(filepath);
            FileReader reader = new FileReader(file);

            Quote [] quotes = gson. fromJson(reader, Quote[].class);
            System.out.println("Num quotes: " + quotes.length);
            int randomIndex = (int)Math.floor(quotes.length * (Math.random()));
            System.out.println(quotes[randomIndex]);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
