package Client;

//Client
import java.io.*;
import java.net.*;

public class Client {

   public static void main(String[] args) throws Exception {
      try {
         Socket socket = new Socket("127.0.0.1", 1234);
         // assign specific ip address
         if (socket.isConnected()) {
            System.out.println("Connected to server");
            // check if connected
         }
         try (FileOutputStream out = new FileOutputStream("path.type")) {
            // read and prepare your file that you want to recive
            DataInputStream in = new DataInputStream(socket.getInputStream());
            int chars;
            while ((chars = in.read()) != -1) {
               out.write((char) chars);
               // recive file via connection from server
            }
         }
         System.out.println("\nFile recive Completed");
         // Data recived Successfully
         socket.close();
         // close connection and end task
      } catch (SocketException socketException) {
         System.out.println(socketException);
         // print if there is error in connection
      } catch (FileNotFoundException nullPointerException) {
         System.out.println(nullPointerException);
         // print if there is error in file
      }
   }
}