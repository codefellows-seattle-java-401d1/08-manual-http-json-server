public class HTTPRequest {
    public String path;

    public HTTPRequest(BufferedReader inFrontClient) {
        processRequest(inFrontClient );
    }
    public void processRequest(BufferedReader inFrontClient) {
        try {
            // peel off the first GET/POST PATH line
            String requestLine = inFromClient.readLine();
            this.path = requestLine.split(" ")[1];
        } catch (IOException e) {

        }
    }
}
