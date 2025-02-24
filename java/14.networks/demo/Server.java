package networks;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server waiting for connection...");
        
        Socket s = ss.accept();
        System.out.println("Client connected");

        DataInputStream dis = new DataInputStream(s.getInputStream());  
        String  str = (String)dis.readUTF();  
        System.out.println("message= " +str);  
        ss.close(); 
    }
  
}
