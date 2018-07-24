package Quotes;
import java.io.*;
import com.google.gson.Gson;

public class Quote {
    public String[] tags;
    public String author;
    public String text;
    public String toString(){
        return "\" " + this.text + "\n " +
                "by" + this.author;
    }
}