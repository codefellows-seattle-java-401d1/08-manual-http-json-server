import java.util.Scanner;

public class HTTPRequest {
    public String requestHandler(String request){
        Scanner requestScanner = new Scanner(request);

        while(requestScanner.hasNextLine()){
            lineChecker.Parser(requestScanner.nextLine());
        }
        return request;
    }
}
