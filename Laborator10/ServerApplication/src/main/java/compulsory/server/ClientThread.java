package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//import static jdk.internal.net.http.common.Utils.close;

public class ClientThread extends Thread {
    private Socket socket = null;
    private ServerSocket serverSocket = null;

    public ClientThread(Socket socket, ServerSocket serverSocket) {
        this.socket = socket;
        this.serverSocket = serverSocket;
    }

//    public void stop() {
////        running.set(false);
//    }

    public void run() {
        try {
            System.out.println("a client hac connected");
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            while (true) {
                String request = in.readLine();
                // Send the response to the oputput stream: server → client
                if (request == null)
                    break;
                if (request.compareTo("exit") == 0) {
                    System.out.println("A plecat");
                    break;
                }
                if (request.compareTo("stop") == 0) {
                    System.out.println("Am primit stop");
                    serverSocket.close();
                    break;
                }
                String raspuns = "Hello " + request + "!";
                out.println(raspuns);
                System.out.println(raspuns);
                out.flush();
            }
            socket.close();
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}