import java.io.BufferedWriter;
import java.io.IOException;

//Copied over from Lab 10
public class HTTPResponse {
    public int statusCode;
    public String body;

    public HTTPResponse(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }


    public void send(BufferedWriter outToClient) {
//    StringBuffer httpBody = new StringBuffer();
//        httpBody.write("<h1>random quotes</h1>\n");
//        httpBody.write("<p>refresh page to see another random quote!</p>\n");
        try {
            outToClient.write("HTTP/1.1 " + this.statusCode + " OK\n");
            outToClient.write("Content-Length: " + this.body.length() + "\n");
            outToClient.write("\n");
            outToClient.write(body + "\n");

            outToClient.flush();
            outToClient.close();

        } catch (IOException e) {
            System.out.println("Error sending HTTP Response. Body: " + this.body);
            e.printStackTrace();
        }
    }
}
