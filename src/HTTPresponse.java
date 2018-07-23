import java.io.BufferedWriter;
import java.io.IOException;

public class HTTPresponse {
    public int statusCode;
    public String body;

    public HTTPresponse(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    public void sendResponse (BufferedWriter toClient) {
        try {
            toClient.write("Http/1.1 " + this.statusCode + " Ok\n");
            toClient.write("Content-Length: " + this.body.length() + "\n");
            toClient.write("\n");
            toClient.write(body + "\n");
            toClient.flush();
            toClient.close();
        } catch (IOException e) {
            System.out.println("Error " + this.body);
            e.printStackTrace();
        }
    }
}
