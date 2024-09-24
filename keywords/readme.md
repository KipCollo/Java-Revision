# Keywords
Words that has its own special meaning in Java and doesn't change from one program to another.i.e if, else

## package

Package is a container that can contain class files, interfaces and subpackages.
package keyword is used to specify a package to which the current file belongs to.


```java
package pack1;
 
class A
{
     //...
}
```

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
## interface

interface keyword is used to define the interfaces in java. It is a mechanism to achieve abstraction. There can be only abstract methods in the Java interface, not method body.


```java
interface MyInterface
{
    void myMethod();
}
```

## extends

extends keyword is used in inheritance. It is used when a class extends another class or an interface extends another interface.


```java
class SuperClass
{
    //Super Class
}
 
class SubClass extends SuperClass
{
    //Sub Class
}
```
## implements

implements keyword is used while implementing an interface.Used when a class implements an interface.


```java
interface MyInterface
{
    void myMethod();
}
 
class MyClass implements MyInterface
{
    public void myMethod()
    {
        System.out.println("My Method");
    }
}
```
## import

import keyword is used to import the members of a particular package into current java file.

```java
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;
```
## class

class keyword is used when defining a class

```java
class Book{

}
```
 ## new

new keyword is used while creating the instances of a class.

```java
class Animal
{
     //...
}
 
public class MainClass
{
    public static void main(String[] args) 
    {
        Animal animal = new Animal();
    }
}
```
## this

this keyword is used to access other members of the same class.


```java
class AnyClass
{
    int i;
  
    AnyClass()
    {
        System.out.println("First Constructor");
    }
  
    AnyClass(int j)
    {
        this();    //calling statement to First Constructor
        System.out.println("Second Constructor");
    }
  
    void methodOne(int i)
    {
        this.i=i;
        System.out.println("From method one");
    }
  
    void methodTwo()
    {
        System.out.println(this.i);  //Accessing same class field
        this.methodOne();      //Accessing same class method
    }
}
```


