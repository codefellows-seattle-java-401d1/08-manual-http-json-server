import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HTTPRequest {
    public String path;

    public HTTPRequest(BufferedReader inFromClient) {
        processRequest(inFromClient);
    }

    public void processRequest(BufferedReader inFromClient) {
        try {
            // peel off the first GET/POST PATH line
            String requestLine = inFromClient.readLine();
//            System.out.println("REQUEST: " + requestLine);

            this.path = requestLine.split(" ")[1];
//
//            // get the next line to collect all the headers
//            String header = inFromClient.readLine();
//            // read lines and assume they're headers until reaching an empty line.
//            while (!header.equals("")) {
//                System.out.println("HEADER: " + header);
//                header = inFromClient.readLine();




//            // peel off the first GET/POST PATH line
//            // "GET /home.html HTTP/1.1"
//            // ["GET", "/home.html", "HTTP/1.1"][1]
//            String requestLine = inFromClient.readLine();
//            this.path = requestLine.split(" ")[1];
//            System.out.println("Request Line: " + requestLine);
//
//            if (this.path.equals("/")) {
//                this.path = "/index.html";
        } catch (IOException e) {
            System.out.println("Error parsing HTTP request: " + this.path);
        }
    }
    //Taken from video
    public Map<String, String>  queryParams() {
        Map<String, String> params = new HashMap<>();
        if (this.path.contains("?")) {
            String queryString = this.path.split("\\?")[1];
            String[] pairs = queryString.split("&");

            for (String param : pairs) {
                String[] keyValue = param.split("=");
                String key = keyValue[0];

                String value = "";
                if (keyValue.length >= 1) {
                    value = keyValue[1];
                }
                params.put(key, value);
            }
        }
        return params;
    }
}
