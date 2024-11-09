package io;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo {

    public static void main(String[] args) throws FileNotFoundException {
        
        // String fileName ="file.txt";
        // FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        // fileOutputStream.write();
        try{
            int value = System.in.read();
            System.out.println(value);

            System.out.println("Hello..");
            System.err.println("Error..");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
