package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("~/Projects/Java/Java-Revision/java/io");
        Path file2 = file.toPath();
        Path fie = Path.of("Collo.txt");
        Path fie2 = Paths.get("col2.txt");
        Path fs = FileSystems.getDefault().getPath("fs.txt");
    
    
        System.out.println(Files.exists(fie2));
        System.out.println(Files.exists(fie));
        System.out.println(Files.exists(file2));
        System.out.println(System.getProperty("file.separator"));
        System.out.println("Helo, World..");
        System.err.println("Error..");

        try{
        int values = System.in.read();
        System.out.println(values);
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

}
