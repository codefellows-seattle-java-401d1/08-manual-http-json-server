
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.*;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONReader {
    public static void main(String[] args) {
        Gson gson = new Gson();

        String json = gson.toJson(file);
        System.out.println(json);

        //example code from class for this part
//        Movies deserialized = gson.fromJson(json, Movies.class);
//        System.out.println(deserialized.title);
//        System.out.println(deserialized.year);


    }

    public static void readJson() throws FileNotFoundException {
        String filename = "recentquotes.json";
        InputStream file = new FileInputStream(filename);
    }


}
