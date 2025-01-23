# Lambda Expressions

A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.The main objective of Lambda expression is to get functional interface benefits.

Lambdas allow you to specify code that will be run later in the program.

Lambda expressions was introduce in 1930 and was big change in mathematics world.It was started to be used in programming kanguages.

Lambda expression is an anonymous function.

1. It doesn't have a name.
2. It doesn't have modifiers
3. No return type.

- Normal Functions

```java

public int sum(int a,int b){
    int result= a+b;
    return result;
}

public void fun(){
    System.out.Println("Lambda")
}

public int getLenth(int side){
    return side.length()
}
```

- Lambda Expression

```java
(int a,int b)->{int result = a+b}//(a,b)->int result =a+b;(This is Type Inference i.e The data type is determined during Runtime)
()->{System.out.Println("Lambda")}//()->System.out.Println("Lambda")
(int side)->{return side.length()}//side->side.length()
```

## Characteristics

1. Lambda Expressions an take any no. of parameters.
2. If multiple parameters are present then it shuld be separated with comma.
3. If only one parameter is present then paranthesis are optional.
4. Type Inference- We do not need to pass data type in parameters,based on context compiler can detect the type automatically.
5. If Lambda method has one statement,then no need of curl braces
6. If Lambda returns something then we can remove return keyword.

Functinal Interfaces are used to call Lambda expressions even if has no name.

Lambda expression is essentially an object.

```java
Printer printer = message -> System.out.println("ambda expression can be defined and stored as objects");
```

## Method References

Method references are another way to make the code easier to read, such as simply mentioning the name of the method. Like lambdas, it takes time to get used to the new syntax.

NOTE:- Remember that :: is like a lambda, and it is used for deferred execution with a functional interface. You can even imagine the method reference as a lambda if it helps you.

A method reference and a lambda behave the same way at runtime. You can pretend the compiler turns your method references into lambdas for you.
There are four formats for method references:

1. static methods
2. Instance methods on a particular object
3. Instance methods on a parameter to be determined at runtime
4. Constructors

- Calling static Methods
For the first example, we use a functional interface that converts a double to a long:

```java
interface Converter {
long round(double num);
}
```

We can implement this interface with the round() method in Math. Here we assign a method reference and a lambda to this functional interface:

```java
Converter methodRef = Math::round;
Converter lambda = x -­> Math.round(x);
System.out.println(methodRef.round(100.1));// 100
```

- Calling Instance Methods on a Parameter
This time, we are going to call the same instance method that doesn’t take any parameters.The trick is that we will do so without knowing the instance in advance. We need a different functional interface this time since it needs to know about the String:

```java
interface StringParameterChecker {
boolean check(String text);
}
```

We can implement this functional interface as follows:

```java
StringParameterChecker methodRef = String::isEmpty;
StringParameterChecker lambda = s -­> s.isEmpty();
System.out.println(methodRef.check("Zoo")); // false
```

- Calling Constructors
A constructor reference is a special type of method reference that uses new instead of a method and instantiates an object. For this example, our functional interface will not take any parameters but will return a String:

```java
interface EmptyStringCreator {
String create();
}
```

To call this, we use new as if it were a method name:

```java
EmptyStringCreator methodRef = String::new;
EmptyStringCreator lambda = () -­> new String();

var myString = methodRef.create();
System.out.println(myString.equals("Snake")); // false
```

## Functional interfaces

Functional interfaces is an interface with single abstract method(SAM).It is used to invoke Lambda Expressions.

Consumers
Suppliers
Functions
Predicates

It can have any no. of default methods and static methods.

Example

```java
public interface Demo{
    public void fun();//abstract method
    default void fun1(){
        //body of default method
    };
    public static void fun2(){
        //body of static
    };
}
```

```java
public interface Demo1{
    public void fun();
    public void fun1();
}
```

Demo is functional interface coz it has one abstract method while Demo1 is not.

@FunctionalInterface annotation is used to indicate that the interface is functional interface.It helps in detection of more than one abstract method.It gives error incase of zero or more than one abstract method.

The @FunctionalInterface annotation tells the compiler that you intend for the code to be a functional interface. If the interface does not follow the rules for a functional interface, the compiler will give you an error.

Java includes @FunctionalInterface on some, but not all, functional interfaces. This annotation means the authors of the interface promise it will be safe to use in a lambda
in the future. However, just because you don’t see the annotation doesn’t mean it’s not a functional interface. Remember that having exactly one abstract method is what makes it a functional interface, not the annotation.

```java
@FunctionalInterface
public interface Demo{
    public void fun();
}
```

Runnable--run()-One abstract method
Callable--call()
Comparable--compareTo()
ActionListener--actionPerformed()

UseCase:

- If any interface extends Functional Interface and child interface does not contain abstract methods then the child is also an Functional Interface.

```java
@FunctionalInterface
public interface Demo{
    public void fun();
}
```

```java
public interface Demo1 extends Demo{//valid Functional interface but not necessarily FI.

}
```

```java
public interface Demo2 extends Demo{
 public void fun1();//Not Functional interface
}
```

```java
@FunctionalInterface
public interface Demo3 extends Demo{//Functional interface

}
```

There is no implementation class for Functional interface.i.e replace implementation class with lambda expressions.Functional Interface contains one abstract method becase Lambda Expression only provides implementation for one method.

There is one exception to the single abstract method rule that you should be familiar with. If a functional interface includes an abstract method with the same signature as a public method found in Object, those methods do not count toward the single abstract method test. The motivation behind this rule is that any class that implements the interface will inherit from Object, as all classes do, and therefore always implement these methods.

## Methods

### Default Methods

They are concrete methods.They are used to replace implementation classes.default keyword is used to define the default methods in an interface.

```java

@FunctionalInterface
public interface MyInterface 
{
    public void funMethod();
    public default void myDefaultMethod() 
    {
        System.out.println("Default Method");
    }
}
```

- Default methods in multiple inheritance:

```java
public interface A{
public default void myDefaultMethod() 
    {
        System.out.println("Default Method A ");
    }
}
```

```java
public interfce B{
 public default void myDefaultMethod() 
    {
        System.out.println("Default Method B");
    }
}
```

```java
public class Test implements A,B{
    //ambiguity - we will get ambiguity
}
```

To override ambigutiy:

```java
public class Test implements A,B{
    public default void myDefaultMethod() 
    {
     A.super.myDefaultMethod();
    }
}
```

Functional Interface with default methods is not equal to abstract classes.

- Abstract class can't refer Lambda expression whereas Functional Interface with default methods can refer Lambda Expression
- Inside Abstract class we can override Object class methods but can't do in Functional Interface
- Inside Abstract class we can declare constructors methods but can't declare in Functional Interface

### Static methods

Are used to define general utility methods.Utility methods are codes that will be used in many places.
Static methods will not be inherited into impl class,so we directly call it from className.

There is no static method overriding.
We can write main method inside interface.

Functional interfaces are of types:

1. User-defined Functional interface- Developer writes using @FunctionalInterface
2. Predefined Functional Interface- Includes (Predicate,Function,Consumer,supplier,BiPrediacte,BiFunction,BiConsumer,UnaryOperator,BinaryOperator)

## Predifined Functional Interface

- Predicate: It is boolean value function.Used to perform some conditional cheks. i.e wherever conditional checks are there use prediacte instead of writing more codes.It will replace the if statements.

Represents a predicate (boolean-valued function) of one argument.This is a functional interface whose functional method is test(Object).

```java
interface Predicate<T>{
    booelean test(T t);
}
```

```java

public boolean test(String s){
    if(String.length > 6){
        return true;
    } else{
        return false;
    }
}
```

```java
()->{
    if(String.length > 6){
        return true;
    } else{
        return false;
    }
}
```

```java
Predicate<String s> p = s-> s.lenght>6;
    p.test("Collins");
```

- Supplier:- A Supplier is used when you want to generate or supply values without taking any input. The Supplier interface is defined as follows:

```java
@FunctionalInterface
public interface Supplier<T> {
T get();
}
```

## Anonymous Inner classes

```java
@FunctionalInterface
public interface Demo{
    public void fun();
}
```

```java
public class DemoImpl implements Demo{
    public void fun(){
        System.out.println("DemoImp printing..");
    }
}
```

```java
public class Show{

    // public static void show(){
    //     demo(new DemoImpl());
    // }

    public static void show(){ //inner class
        demo(new Demo(){
          public void fun(){
           System.out.println("InnerClass printing..");
          }
        });
    }

    public static void demo(Demo demo){
        demo.fun()
    }
}
```
