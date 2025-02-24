package networks;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.URI;

public class Demo {

    public static void main(String[] args){

        // URI uri = URI.create("https://github.com/KipCollo");
        
        // try(InputStream inputStream = uri.toURL().openStream();
        // ){
        //     int read =inputStream.read();
        //     System.out.println(read);
        // }catch (Exception e) {
        //    e.printStackTrace();
        // }
        try{
        ServerSocket serverSocket = new ServerSocket(8080);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println();
        }
    }

}
