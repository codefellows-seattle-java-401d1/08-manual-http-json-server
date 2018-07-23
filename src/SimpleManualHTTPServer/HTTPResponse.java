package SimpleManualHTTPServer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.*;
import java.net.*;

//HTTPResponse responsible for generating proper HTTP Responses
public class HTTPResponse {
    public int statusCode;
    public String body;

    public HTTPResponse(int statusCode, String body){
        this.statusCode = statusCode;
        this.body = body;
    }

    public void send(BufferedWriter outToClient){
        try{
            outToClient.write("HTTP/1.1 " + statusCode + "\n");
            outToClient.write("Content-Length: " + this.body.length() + "\n");
            outToClient.write("\n");
            outToClient.write(body + "\n");

            //flush means out the buffer - forces send
            outToClient.flush();

            //closes request
            outToClient.close();

        } catch (IOException e){
            System.out.println("Error sending HTTP response");
            System.out.println("Response Body: " + this.body);
            e.printStackTrace();
        }
    }
}
