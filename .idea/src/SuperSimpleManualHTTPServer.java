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

            HTTPRequest request = new  HTTPRequest(inFromClient);
            HTTPStaticFileReader file = new HTTPStaticFileReader(request);

            int statusCode = 200;
            String body = "";
            HTTPResponse response = new HTTPResponse(statusCode, body);
            response.send();

            String message = "<h1>neato</h1>";
            outToClient.write("HTTP/1.1 200 OK\n");
            outToClient.write("Content-Length: " + message.length() + "\n");
            outToClient.write("\n");
            outToClient.write(message + "\n");

            outToClient.flush();
            outToClient.close();

            System.out.println("closed request.");
        }
    }
}
