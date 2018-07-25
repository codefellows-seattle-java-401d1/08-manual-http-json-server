import java.io.File;
import java.io.FileNotFoundException;
//import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class lineChecker {
    private static GsonBuilder builder = new GsonBuilder();

    public static String Parser(String lineForCheck){
        String jsonData;
        String lineToAppend = "default";
        if(lineForCheck.matches("(.*)[{](.*)[}](.*)")){
            jsonData = lineForCheck.split("[{][{]")[1].split("[}][}]")[0];
            if(jsonData.equals("RANDOM_JSON_QUOTE")) {
                Quote jsonReturn = randomQuoteFinder();
                String jsonAppend = "author: " + jsonReturn.author + "  Likes: " +jsonReturn.likes + "\n Quote: " + jsonReturn.text;
                lineToAppend = lineForCheck.split("[{][{]")[0] + jsonReturn + lineForCheck.split("[}][}]")[1];
            }else{
                lineToAppend = lineForCheck;
            }
        }else{
            lineToAppend = lineForCheck;
        }
        return lineToAppend;
    }

    public static Quote randomQuoteFinder(){
        Gson gson = builder.create();
        File input;
        Scanner jsonScanner;
        try{
            input = new File("resources/recentquotes.json");
            jsonScanner = new Scanner(input);
        }
        catch(FileNotFoundException e)
        {
            Quote errorReturn = new Quote("404 error","404","File not found.");
            return errorReturn;
        }

        int quotesLineNumber = 0;
        while(jsonScanner.hasNextLine()){
            jsonScanner.nextLine();
            quotesLineNumber++;
        }
        Random rng = new Random();
        quotesLineNumber = rng.nextInt(quotesLineNumber-1);
        try{
            input = new File("resources/recentquotes.json");
            jsonScanner = new Scanner(input);
        }
        catch(FileNotFoundException e)
        {
            Quote errorReturn = new Quote("404 error","404","File not found.");
            return errorReturn;
        }
        jsonScanner.useDelimiter("\\Z");
        String fileContents = jsonScanner.next();
        Quote[] quoteArray=gson.fromJson(fileContents,Quote[].class);
        return quoteArray[quotesLineNumber];
//        Object returnVal = jsonList.get(quotesLineNumber-1);
//        return gson.fromJson(returnVal.toString(),Quote.class);
    }

}
