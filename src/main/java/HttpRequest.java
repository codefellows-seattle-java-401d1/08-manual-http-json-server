package main.java;
import java.io.*;

public class HttpRequest {
    public String path;

    public HttpRequest(BufferedReader inFromClient) {
        getLine (inFromClient);
    }
    public void getLine(BufferedReader inFromClient){
        try {
            String line = inFromClient.readLine();
            this.path = line.split(" ")[1];

            if(this.path.equals("/")){
                this.path = "index.html";
            } else {
                this.path = "index.html";
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}