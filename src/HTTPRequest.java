import java.io.BufferedReader;
import java.io.IOException;

public class HTTPRequest {
    public String path;

    public HTTPRequest(BufferedReader inFromClient) {
        processRequest(inFromClient);
    }

    public void processRequest(BufferedReader inFromClient) {
        try {
            String requestLine = inFromClient.readLine();
            this.path = requestLine.split(" ")[1];

            if (this.path.equals("/")) {
                this.path = "/index.html";
            } else {
                this.path = "/home.html";
            }
        } catch (IOException e) {
            System.out.println("Error parsing HTTP request: " + this.path);
        }
    }
}
