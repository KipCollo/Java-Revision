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

enum keyword is used to define enum types.Enum type is special data type that enables a variable to be a set of pre-defined constants.The variable must be equal to one of values that has been predefined.

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

## transient

transient keyword is used in serialization. A variable which is declared as transient will not be eligible for serialization.

```java
class MyClass implements Serializable
{
    int a;
        
    transient String s;   //This will not be serialized
        
    double d;
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

## abstract

abstract keyword is used to implement the abstraction in java. A method which doesn’t have method definition must be declared as abstract and the class containing it must be declared as abstract. You can’t instantiate abstract classes. Abstract methods must be implemented in the sub classes. You can’t use abstract keyword with variables and constructors.

```java
abstract class AbstractClass
{
    abstract void abstractMethod();
}
```

## break

The break keyword is used to stop the execution of a loop(for, while, switch-case) based on some condition.

```java
for (int i = 0; i < 100; i++)
{
    System.out.println(i);
             
    if(i == 50) break;
}
```

## switch        case

Both switch and case keywords are used in the switch-case statement.

```java
Scanner sc = new Scanner(System.in);

System.out.println("Enter Day :");

int day = sc.nextInt();

switch (day) 
{
    case 1:
        System.out.println("SUNDAY");
        break;

    case 2:
        System.out.println("MONDAY");
        break;

    //...

    case 7:
        System.out.println("SATURDAY");
        break;

    default:
        System.out.println("Invalid");
        break;
}
```

## default

default keyword is used to define the default methods in an interface (From Java 8). default keyword is also used in the switch-case statements.

```java
interface MyInterface 
{
    public default void myDefaultMethod() 
    {
        System.out.println("Default Method");
    }
}
```

## if  else

if and else keywords are used in if-else block.

```java
Scanner sc = new Scanner(System.in);
         
System.out.println("Enter a string :");
         
String input = sc.next();
         
if(input.equalsIgnoreCase("JAVA"))
{
    System.out.println("It's JAVA");
}
else
{
    System.out.println("It's not JAVA");
}
```

TODO## Var
