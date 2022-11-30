package Controllers;

import View.Main;
import View.outputView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class ClientHandler implements Runnable{

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket client) throws IOException {
        this.client = client;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
    }

    @Override
    public void run() {
//        try {
//            String [] s ={};
//            outputView v = new outputView();
//            v.output(out, in);
//            Main.main(s);
//        }catch (SocketException e){
//            System.err.println("socket exception");
//        }catch (Exception e){
//            System.err.println("exception in input streams");
//        } finally {
//            out.close();
//            try {
//                in.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
}
