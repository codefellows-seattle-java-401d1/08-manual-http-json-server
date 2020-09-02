package quotes;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

class AccessQuoteTest {

    public static Quote renderQuoteTestVersion(int index) {
        Quote quote = new Quote();
        try {
            Gson gson = new Gson();
            String filepath = "/Users/tara/Desktop/code-fellows/java-401d1/labs/08-manual-http-json-server/recentquotes.json";
            File file = new File(filepath);
            FileReader reader = new FileReader(file);

            Quote[] quotes = gson.fromJson(reader, Quote[].class);

            System.out.println("Num quotes: " + quotes.length);

            quote = quotes[index];
            return quote;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return quote;
    }

    @Test
    void renderRandomQuoteDisplayTest() {

        String result = AccessQuote.renderQuote().toString();

        boolean expected = true;
        if (result.isEmpty()) {
            expected = false;
        }

        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);

        assertTrue(expected);
    }

    @Test
    void renderFirstQuoteTest() {
        String authorExpected = "Marilyn Monroe";
        String authorResult = renderQuoteTestVersion(0).author;

        String quoteExpected = "\n      \u201cI am good, but not an angel. I do sin, but I am not the devil. I am just a small girl in a big world trying to find someone to love.\u201d\n  ";
        String quoteResult = renderQuoteTestVersion(0).text;

        System.out.println("Author expected: " + authorExpected);
        System.out.println("Author result: " + authorResult);
        System.out.println("Quote expected: " + quoteExpected);
        System.out.println("Quote result: " + quoteResult);

        assertEquals(authorExpected, authorResult);
        assertEquals(quoteExpected, quoteResult);
    }

    @Test
    void renderEighthQuoteTest() {
        String authorExpected = "Louis Armstrong";
        String authorResult = renderQuoteTestVersion(8).author;

        String quoteExpected = "\n      \u201cWhat we play is life.\u201d\n  ";
        String quoteResult = renderQuoteTestVersion(8).text;

        System.out.println("Author expected: " + authorExpected);
        System.out.println("Author result: " + authorResult);
        System.out.println("Quote expected: " + quoteExpected);
        System.out.println("Quote result: " + quoteResult);

        assertEquals(authorExpected, authorResult);
        assertEquals(quoteExpected, quoteResult);
    }

    @Test
    void renderLastQuoteTest() {
        String result = renderQuoteTestVersion(229).likes;
        // add text check

        System.out.println(result);

        assertEquals("0 likes", result);
    }
}