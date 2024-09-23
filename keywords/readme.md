# Keywords
Words that has its own special meaning in Java and doesn't change from one program to another.i.e if, else

## enum

enum keyword is used to define enum types.Enum type is special data type that enables a variable to be a set of pre-defined constants.The variable 
must be equal to one of values that has been predefined.


```java
public enum Color
{
    RED, GREEN, BLUE;
}
 
public class Main
{
    public static void main(String[] args)
    {
        Color c1 = Color.RED;
        System.out.println(c1);
    }
}
```
