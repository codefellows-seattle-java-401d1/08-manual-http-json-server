import java.util.Scanner;

public class HTTPResponse {
    public String errorCode(int errorCode){
        errorCodeText(errorCode);
        return "error "+errorCode + ": " + errorCodeText(errorCode);
    }

    public static String randomQuote(){
        Quote quoteToPrint = lineChecker.randomQuoteFinder();
        return quoteToPrint.text+"\nAuthor: "+quoteToPrint.author+quoteToPrint.likes;
    }

    private static String errorCodeText(int errorCode){
        switch(errorCode){
            case 404: return "File Not Found";
        }
        return "default error return";
    }
}
