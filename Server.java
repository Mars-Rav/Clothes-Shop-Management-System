package Controllers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
    private ExecutorService pool = Executors.newFixedThreadPool(5);

    public Server(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8881);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 8881.");
        }

        Socket clientSocket = null;
        try {
            while(true){
                System.out.println("Waiting for client connection");
                clientSocket = serverSocket.accept();
                System.out.println("Connected to a client");

                ClientHandler client = new ClientHandler(clientSocket);
                clients.add(client);

                pool.execute(client);
            }
        } catch (IOException e) {
            System.err.println("Accept failed.");
        }
    }

}
