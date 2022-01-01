package Server;

import java.io.*;
import java.net.*;

class Server {

    public static void main(String args[]) throws Exception {

        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();
            System.out.println("connected..........");
            FileInputStream in = new FileInputStream("D:\\Engenieering\\HossamHaggag-2.pdf");
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            int r;
            while ((r = in.read()) != -1) {
                out.write(r);

            }
            System.out.println("\nFiletranfer Completed");
            socket.close();
            serverSocket.close();

        } catch (SocketException socketException) {
            System.out.println(socketException);
            // TODO: handle exception
        }

    }
}