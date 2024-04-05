package multiThreadingPractice1;

import java.io.*;
import java.net.*;


import java.io.*;
import java.net.*;
import java.util.Date;

public class Server {
    public static void main(String[] args) throws IOException {
        // Create server socket
        ServerSocket serverSocket = new ServerSocket(6969);
        System.out.println("Server started at " + new Date());

        // Listen for client connections
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected at " + new Date());

            // Get input and output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Track when the client disconnects
            Date disconnectTime = null;

            // Communicate with the client
            while (true) {
                String request = input.readLine();

                // If the client sends "bye", end the connection
                if (request.equals("bye")) {
                    disconnectTime = new Date();
                    System.out.println("Client disconnected at " + disconnectTime);
                    break;
                }

                // Otherwise, square the number and send it back to the client
                int number = Integer.parseInt(request);
                int result = number * number;
                output.println(result);
            }

            // Close the socket
            socket.close();
        }
    }
}
