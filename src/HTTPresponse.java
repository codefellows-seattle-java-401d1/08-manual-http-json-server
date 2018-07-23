import java.io.BufferedWriter;
import java.io.IOException;

public class HTTPresponse {
    public int statusCode;
    public String body;

    public HTTPresponse(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    public void sendResponse (BufferedWriter outToClient) {
        try {
            outToClient.write("HTTP/1.1 200 OK\n");
            outToClient.write("Content-Length: " + this.body.length() + "\n");
            outToClient.write("\n");
            outToClient.write(body + "\n");

            outToClient.flush();
            outToClient.close();
        } catch (IOException e) {
            System.out.println("Error " + this.body);
            e.printStackTrace();
        }
    }
}
