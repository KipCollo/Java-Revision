package networks;

import java.io.InputStream;
import java.net.URI;

public class Demo {

    public static void main(String[] args){

        URI uri = URI.create("https://github.com/KipCollo");
        
        try(InputStream inputStream = uri.toURL().openStream();
        ){
            int read =inputStream.read();
            System.out.println(read);
        }catch (Exception e) {
           e.printStackTrace();
        }
    }

}
