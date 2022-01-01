package Server;

import java.io.*;
import java.net.*;

class Server {

    public static void main(String args[]) throws Exception {

        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            // assign specific ip address
            Socket socket = serverSocket.accept();
            System.out.println("connected..........");
            // server connected successfully
            FileInputStream in = new FileInputStream("path.type");
            // read and prepare your file that you want to broadcast
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            int chars;
            while ((chars = in.read()) != -1) {
                out.write(chars);
                // send file via connection to the clients
            }
            System.out.println("\nFiletrasnfer Completed");
            // Data transfered Successfully
            socket.close();
            serverSocket.close();
            // close connection and end task

        } catch (SocketException socketException) {
            System.out.println(socketException);
            // print if there is error in connection
        } catch (NullPointerException nullPointerException) {
            System.out.println(nullPointerException);
            // print if there is error in variabls
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException);
            // print if there is error in file
        }

    }
}