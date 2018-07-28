package Quotes;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

class AccessQuoteTest {

    /*
    === TEST REQUIREMENTS ===
    Use JUnit to write a test to make sure quotes are chosen appropriately
    Test to make sure there are no ArrayIndexOutOfBounds exceptions by having off-by-one errors at the front or back of the list.
    make a test that guarantees the first quote is returned
    make a test that guarantees a middle quote is returned
    make a test that guarantees the last quote is returned
     */

    @Test
    void quoteRandomizer() throws FileNotFoundException {
        QuotesConstructor quote = null;
        Gson gson = new Gson();
        String filepath = "/Users/amycohen/codefellows/401/lab-amy/08-manual-http-json-server/src/recentquotes.json";
        File file = new File(filepath);
        FileReader reader = new FileReader(file);

        QuotesConstructor[] quotes = gson.fromJson(reader, QuotesConstructor[].class);
        System.out.println("Num quotes: " + quotes.length);

//        int randomIndex = (int) Math.floor(quotes.length * Math.random());
//        quote = quotes[randomIndex];

        Quotes.QuotesConstructor actual = quote = quotes[0];
        String expected = "I am good, but not an angel. I do sin, but I am not the devil. I am just a small girl in a big world trying to find someone to love. -Marilyn Monroe";
        System.out.println(quote);

        assertEquals(expected, actual);

    }
}