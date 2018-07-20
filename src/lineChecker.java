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
                String jsonAppend = "author: " + jsonReturn.Author + "  Likes: " +jsonReturn.Likes + "\n Quote: " + jsonReturn.Text;
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
        Scanner jsonScanner = new Scanner(Server.root+"recentquotes.json");
        int quotesLineNumber = 0;
        while(jsonScanner.hasNextLine()){
            jsonScanner.nextLine();
            quotesLineNumber++;
        }
        Random rng = new Random();
        quotesLineNumber = rng.nextInt(quotesLineNumber-1);
        jsonScanner = new Scanner(Server.root+"recentquotes.json");
        for(int i = 0; i<quotesLineNumber;i++){
            jsonScanner.nextLine();
        }
        return gson.fromJson(jsonScanner.nextLine(),Quote.class);
    }

}
