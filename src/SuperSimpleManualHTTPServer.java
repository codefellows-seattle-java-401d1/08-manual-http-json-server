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

            HTTPRequest request = new HTTPRequest(inFromClient);
            HTTPStaticFileReader file = new HTTPStaticFileReader(request);


           try {
               int statusCode = 200;
               String body = file.contentReader();
               HTTPresponse response = new HTTPresponse(statusCode, body);
               response.sendResponse(outToClient);
           } catch (FileNotFoundException e) {
               HTTPresponse response = new HTTPresponse(404, "Could Not find " + request.path);
               response.sendResponse(outToClient);
           } catch (IOException e) {
               HTTPresponse response = new HTTPresponse(500, "Internal Service Error");
               response.sendResponse(outToClient);
           }
            System.out.println("closed request.");
        }
    }
}
