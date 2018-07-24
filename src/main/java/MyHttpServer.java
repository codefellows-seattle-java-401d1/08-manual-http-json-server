package main.java;

import java.io.*;
import java.net.*;

class MyHttpServer {
    public static final int PORT = 6789;

    public static void main(String argv[]) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(PORT);
        System.out.println("Listening on http://localhost:" + PORT);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("waiting for request...");
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            BufferedWriter outToClient = new BufferedWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));

            // peel off the first GET/POST PATH line
            String requestLine = inFromClient.readLine();
            System.out.println("REQUEST: " + requestLine);

            String header = inFromClient.readLine();
            while (!header.equals("")) {
                System.out.println("HEADER: " + header);
                header = inFromClient.readLine();
            }

            String message = "<h1>Hey</h1>";
            outToClient.write("HTTP/1.1 200 OK\n");
            outToClient.write("Content-Length: " + message.length() + "\n");
            outToClient.write(message + "\n");
            outToClient.flush();
            outToClient.close();
            System.out.println("request closed");
        }
    }
}
