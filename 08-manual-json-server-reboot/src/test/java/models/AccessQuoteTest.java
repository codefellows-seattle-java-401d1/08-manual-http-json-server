package models;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

class AccessQuoteTest {
    
    @Test
    void firstQuote() throws FileNotFoundException {
        QuotesConstructor quote = null;
        Gson gson = new Gson();

        String filepath = "/Users/amycohen/codefellows/401/lab-amy/08-manual-http-json-server/08-manual-json-server-reboot/src/main/resources/public/recentquotes.json";
        File file = new File(filepath);
        FileReader reader = new FileReader(file);
        QuotesConstructor[] quotes = gson.fromJson(reader, QuotesConstructor[].class);

        //I added a 2nd JSON file so I could clearly return just a few expected answer to make sure that I could get the ones that I was looking for.
        String filepath2 = "/Users/amycohen/codefellows/401/lab-amy/08-manual-http-json-server/08-manual-json-server-reboot/src/main/resources/public/TestQuotesOnly.json";
        File file2 = new File(filepath2);
        FileReader reader2 = new FileReader(file2);
        QuotesConstructor[] quotes2 = gson.fromJson(reader2, QuotesConstructor[].class);


        String actual = quotes[0].toString();
        String expected = quotes2[0].toString();

        System.out.println("actual: " + actual);
        System.out.println("expected: " + expected);

        assertEquals(expected, actual);
    }

    @Test
    void lastQuote() throws FileNotFoundException {
        QuotesConstructor quote = null;
        Gson gson = new Gson();

        String filepath = "/Users/amycohen/codefellows/401/lab-amy/08-manual-http-json-server/08-manual-json-server-reboot/src/main/resources/public/recentquotes.json";
        File file = new File(filepath);
        FileReader reader = new FileReader(file);
        QuotesConstructor[] quotes = gson.fromJson(reader, QuotesConstructor[].class);

        //I added a 2nd JSON file so I could clearly return just a few expected answer to make sure that I could get the ones that I was looking for.
        String filepath2 = "/Users/amycohen/codefellows/401/lab-amy/08-manual-http-json-server/08-manual-json-server-reboot/src/main/resources/public/TestQuotesOnly.json";
        File file2 = new File(filepath2);
        FileReader reader2 = new FileReader(file2);
        QuotesConstructor[] quotes2 = gson.fromJson(reader2, QuotesConstructor[].class);

        String actual = quotes[quotes.length-1].toString();
        String expected = quotes2[quotes2.length-1].toString();

        System.out.println("actual: " + actual);
        System.out.println("expected: " + expected);

        assertEquals(expected, actual);
    }

    @Test
    void middleQuote() throws FileNotFoundException {
        QuotesConstructor quote = null;
        Gson gson = new Gson();

        String filepath = "/Users/amycohen/codefellows/401/lab-amy/08-manual-http-json-server/08-manual-json-server-reboot/src/main/resources/public/recentquotes.json";
        File file = new File(filepath);
        FileReader reader = new FileReader(file);
        QuotesConstructor[] quotes = gson.fromJson(reader, QuotesConstructor[].class);

        //I added a 2nd JSON file so I could clearly return just a few expected answer to make sure that I could get the ones that I was looking for.
        String filepath2 = "/Users/amycohen/codefellows/401/lab-amy/08-manual-http-json-server/08-manual-json-server-reboot/src/main/resources/public/TestQuotesOnly.json";
        File file2 = new File(filepath2);
        FileReader reader2 = new FileReader(file2);
        QuotesConstructor[] quotes2 = gson.fromJson(reader2, QuotesConstructor[].class);

        String actual = quotes[28].toString();
        String expected = quotes2[1].toString();

        System.out.println("actual: " + actual);
        System.out.println("expected: " + expected);

        assertEquals(expected, actual);
    }
}