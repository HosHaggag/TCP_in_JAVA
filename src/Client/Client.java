package Client;

//Client
import java.io.*;
import java.net.*;

public class Client {

   public static void main(String[] args) throws Exception {
      try {

         Socket socket = new Socket("127.0.0.1", 1234);
         if (socket.isConnected()) {
            System.out.println("Connected to server");
         }
         try (FileOutputStream out = new FileOutputStream("received.txt")) {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            int chars;
            while ((chars = in.read()) != -1) {
               out.write((char) chars);
            }
         }
         socket.close();

      } catch (SocketException socketException) {
         System.out.println(socketException);
      }

   }

}