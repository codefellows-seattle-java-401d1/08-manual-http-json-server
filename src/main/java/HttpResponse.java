package main.java;
import java.io.*;
import java.io.BufferedWriter;

public class HttpResponse {
    public String line;
    public int status;

    public HttpResponse(String lines, int stat){
        this.status = stat;
        this.line = lines;
    }
    public void respond(BufferedWriter outToClient){
        try{
            outToClient.write("HTTP/1.1 " + status + "\n");
            outToClient.write("Content-Length: " + this.line.length() + line + "\n");
            outToClient.flush();
            outToClient.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
