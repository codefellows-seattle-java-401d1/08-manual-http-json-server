import java.io.*;
import java.net.*;

public class Server {
    static String root = "./resources";
    static int PORT;

    public static void main(String[] args)throws Exception{
        PORT = 02543;
        if(args[0]!=null){
            PORT = Integer.parseInt(args[0]);
        }

        ServerSocket welcomeSocket = new ServerSocket(PORT);
        System.out.println("Listening on http://localhost:)" + PORT);

        Boolean isUp = true;
        while(isUp == true){
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            BufferedWriter outToClient = new BufferedWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));

            String requestLine = inFromClient.readLine();
            System.out.println("Request: " + requestLine);

            String header = inFromClient.readLine();

            while (!header.equals("")){
                System.out.println("HEADER: " + header);
                header = inFromClient.readLine();
            }

            String message = "Your random quote is:";
            message += HTTPResponse.randomQuote();
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
