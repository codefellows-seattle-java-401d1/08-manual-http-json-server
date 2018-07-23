package SimpleManualHTTPServer;
import java.io.IOException;
import java.io.*;

///responsible for parsing and defining structure of proper HTTP request
public class HTTPRequest {
    public String path;

    public HTTPRequest(BufferedReader inFromClient) {
        processRequest (inFromClient);
        }

    public void processRequest(BufferedReader inFromClient){
        try {
            // peel off the first GET/POST PATH line
            String requestLine = inFromClient.readLine();

            //"GET /index.html HTTP/1.1"
            // /index.html is the index 1 of the array of strings
            this.path = requestLine.split(" ")[1];

            if(this.path.equals("/")){
                this.path = "index.html";
            } else {
                this.path = "home.html";
            }
        } catch (IOException e){
            System.out.println("Error parsing HTTP request: " + this.path);
        }

    }
}
