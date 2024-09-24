package Intermediate.serialization;

import java.io.*; 

public class Serialize {

 
class Persist{  
 public static void main(String args[])throws Exception{  
  Student s1 =new Student(211,"John");  
  
  FileOutputStream fout=new FileOutputStream("f.txt");  
  ObjectOutputStream out=new ObjectOutputStream(fout);  
  
  out.writeObject(s1);  
  out.flush();  
  System.out.println("success");  
 } 
} 
}
