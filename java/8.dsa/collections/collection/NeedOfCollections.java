class Student{

}

class Book{

}

public class NeedOfCollections {

    public static void main(String[] args){

        int a=1;
        int b=2;
        int c=3;
        int d=4;
        int e=5;
        int f=6;
        int g=7;// If you need to store ten thousand intervals you'll create 10,000 variables

        //To solve the problem we use Arrays
        int arr[]= new int[10000];

        //Limitations of array
        /*
         * 1. Fixed sizes
         * 2. Holds homogeneous data types/elements
         * 3. Doesn't provide ready made APIs and methods for algorithms
         */

         Student[] students= new Student[20];// Fixed to 10 students
         students[0]= new Student();
         students[1]=new Student();
         //students[1]=new Book();
          // Causes error since array hold homegenous data element

         //To solve problem of homogeneous in arrays you use Object class
         Object object[] = new Object[10];
         object[0]=new Student();
         object[1]=new Book();
         object[2]=new String();




    }
}
