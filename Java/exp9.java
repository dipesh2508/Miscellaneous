import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class exp9 {
    public static void main(String[] args) throws IOException {
        // Create a simple HTTP server on port 8000
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        
        // Set a handler for the root path "/"
        server.createContext("/", new MyHandler());
        
        // Start the server
        server.start();
        
        System.out.println("Server started on port 8000");
    }
    
    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Set response headers
            exchange.getResponseHeaders().set("Content-Type", "text/html");
            exchange.sendResponseHeaders(200, 0);
            
            // Get the output stream
            OutputStream outputStream = exchange.getResponseBody();
            
            // Write HTML response
            String response = "<html><body><h1>Hello from Java Web Server!</h1></body></html>";
            outputStream.write(response.getBytes());
            
            // Close the output stream
            outputStream.close();
        }
    }
}
